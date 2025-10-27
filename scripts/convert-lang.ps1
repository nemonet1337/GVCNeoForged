param(
    [string]$LangDir = "src/main/resources/assets/gvcneoforged/lang"
)

if (-not (Test-Path -Path $LangDir)) {
    Write-Error "Lang directory not found: $LangDir"
    exit 1
}

$resolvedPath = (Resolve-Path -Path $LangDir).Path

Get-ChildItem -Path $resolvedPath -Filter *.lang | ForEach-Object {
    $langFile = $_
    $entries = [ordered]@{}

    foreach ($rawLine in Get-Content -Path $langFile.FullName) {
        $line = $rawLine.Trim()
        if ([string]::IsNullOrWhiteSpace($line)) { continue }
        if ($line.StartsWith('#')) { continue }
        if (-not $line.Contains('=')) { continue }

        $parts = $line.Split('=', 2)
        $key = $parts[0].Trim()
        $value = $parts[1].Trim()
        $entries[$key] = $value
    }

    $json = $entries | ConvertTo-Json -Depth 3
    $destName = ($langFile.BaseName.ToLowerInvariant()) + '.json'
    $destPath = Join-Path -Path $resolvedPath -ChildPath $destName
    [System.IO.File]::WriteAllText($destPath, $json + [Environment]::NewLine, [System.Text.Encoding]::UTF8)
    Write-Host "Converted $($langFile.Name) -> $destName"
}
