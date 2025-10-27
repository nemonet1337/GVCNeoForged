# config設定
READMEから移植

### gvcr2.cfg

#### entity
```
B:cfg_damage_relief_mob=true     true時ゲリラ等モブからのダメージが減少します
B:cfg_damage_relief_vehicle=true true時搭乗している乗り物が、受けるダメージを減少します
B:cfg_exprotion_mob=true         true時ゲリラ等が起こす爆発でブロックが壊れます
B:cfg_exprotion_player=true      true時プレイヤーが起こす爆発でブロックが壊れます
B:cfg_movebreak=true             true時乗り物が移動時草木を破壊します
B:cfg_vehicle_angle=true         true時、3人称視点で乗り物が傾くように
I:cfg_targeting_time=30          ゲリラが発見時から射撃に移るまでの時間(この値-難易度*5)
```

#### mob_spawn_limit
```
I:cfg_spawn_limit_car=20         車系モブの最大湧き数です
I:cfg_spawn_limit_car_max=10      車系モブの最大湧きグループ数です
I:cfg_spawn_limit_car_min=5       車系モブの最小湧きグループ数です
I:cfg_spawn_limit_g=100           ゲリラの最大湧き数です
I:cfg_spawn_limit_g_max=200       ゲリラの最大湧きグループ数です
I:cfg_spawn_limit_g_min=100       ゲリラの最小湧きグループ数です
I:cfg_spawn_limit_heli=10         ヘリ系モブの最大湧き数です
I:cfg_spawn_limit_heli_max=2      ヘリ系モブの最大湧きグループ数です
I:cfg_spawn_limit_heli_min=1      ヘリ系モブの最小湧きグループ数です
I:cfg_spawn_limit_s=20            同盟軍の最大湧き数です
I:cfg_spawn_limit_s_max=80        同盟軍の最大湧きグループ数です
I:cfg_spawn_limit_s_min=50        同盟軍の最小湧きグループ数です
I:cfg_spawn_limit_tank=10         戦車系モブの最大湧き数です
I:cfg_spawn_limit_tank_max=2      戦車モブの最大湧きグループ数です
I:cfg_spawn_limit_tank_min=1      戦車モブの最小湧きグループ数です
```

#### spawn
```
B:cfg_canspawn=true               true時ゲリラや同盟軍などが湧きます。false時これ以降の設定を無視して自然湧きしなくなります
B:cfg_canspawn_anotherworld=false true時他modで追加されるディメンションにも出現するようになります
B:cfg_canspawn_hell=true          true時ネザーに出現するようになります
B:cfg_canspawn_mob_car=true       true時車系モブが出現するようになります
B:cfg_canspawn_mob_ge=true        true時ゲリラが出現するようになります
B:cfg_canspawn_mob_heli=true      true時ヘリ系モブが出現するようになります
B:cfg_canspawn_mob_so=true        true時同盟軍が出現するようになります
B:cfg_canspawn_mob_tank=true      true時戦車系モブが出現するようになります
B:cfg_canspawn_sky=false          true時エンドに出現するようになります
B:cfg_canspawn_underground=false  true時地下に出現するようになります
```

#### structure
```
B:cfg_building_ally_dungeon=true      true時同盟軍の基地が生成されます
B:cfg_building_boss_dungeon=true      true時大型ダンジョンが生成されます
B:cfg_building_dungeon=true           true時小規模ダンジョンが生成されます
B:cfg_building_huge_dungeon=true      true時中規模ダンジョンが生成されます
B:cfg_building_mine=true              true時IEDなどが地表に生成されます
I:cfg_building_rand_ally_dungeon=600  同盟軍の基地の生成率です
I:cfg_building_rand_boss_dungeon=800  大型ダンジョンの生成率です
I:cfg_building_rand_dungeon=80        小規模ダンジョンの生成率です
I:cfg_building_rand_huge_dungeon=500  中規模ダンジョンの生成率です
I:cfg_building_rand_mine=20           IEDなどの生成率です
B:cfg_building_supplies=true          true時スポーン時に支援物資が生成されます

B:cfg_building_dungeon_spawner=true   false時ダンジョンに生成されるスポーンブロックや
                                      拠点ブロックを消去します

I:cfg_building_offset_rand_boss_dungeon=7  大型ダンジョンの生成間隔です。7*128ブロック間隔で生成されます
I:cfg_building_offset_rand_dungeon=20       小型ダンジョンの生成率です
I:cfg_building_offset_rand_huge_dungeon=40 中型ダンジョンの生成率です
B:cfg_building_offsettype=true             falseにすると従来通りの生成方法になります
```