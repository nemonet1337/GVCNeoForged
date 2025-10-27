package gvcr2.block.tile;
 
import java.util.List;

import gvcr2.mod_GVCR2;
import gvcr2.entity.mob.EntityGVCR2_GE_Jamming;
import gvcr2.entity.mob.EntityGVCR2_GE_S;
import gvcr2.entity.so.EntityGVCR2_SO_S;
import gvcr2.entity.vehicle.car.EntityGVCR2_CAR_Technical;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH1S;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_AH6;
import gvcr2.entity.vehicle.heli.EntityGVCR2_HELI_R22;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_M60A1;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_PT76;
import gvcr2.entity.vehicle.tank.EntityGVCR2_TANK_T34;
import gvcr2.event.level.GVCR2WorldDifficultyLevel;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
 
public class TileEntityBlockBaseFlag extends TileEntityBlockBaseFlag_Base implements ITickable
{
	
	
    @Override
	public void update() {
    	Block block = this.world.getBlockState(this.pos).getBlock();
        Entity entity = null;
        int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
        super.update();
       
        if(!mod_GVCR2.cfg_building_dungeon_spawner) {
        	if(!this.world.isRemote){
            	this.world.setBlockToAir(pos);
            }
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_playerbase
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_playerbase) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_playerbase.name";
        	 this.base_boss = false;
        	 this.flag_range = 16;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_playerbase) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_playerbase;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_playerbase;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_city
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_city) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_city.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_city) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_city;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_city;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ship
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_ship) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_ship.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ship) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_ship;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_ship;
            }
           
        	this.Mob_spawn(x, y, z, 3);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ruins
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_ruins) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_ruins.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ruins) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_ruins;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_ruins;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_abandoned_factory
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_abandoned_factory) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_abandoned_factory.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_abandoned_factory) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_abandoned_factory;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_abandoned_factory;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_airfield
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_airfield) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_airfield.name";
        	 this.base_boss = false;
        	 this.flag_range = 20;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_airfield) {
            	enemy = true; 
            	spawn_heli = true;
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_airfield;
            }else {
            	 enemy = false;
            	 spawn_heli = true;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_airfield;
            }
           
        	this.Mob_spawn(x, y, z, 0);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_airbase
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_airbase) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_airbase.name";
        	 this.flag_range = 20;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_airbase) {
            	enemy = true; 
            	spawn_heli = true;
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_airbase;
            }else {
            	 enemy = false;
            	 spawn_heli = true;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_airbase;
            }
           
        	this.Mob_spawn(x, y, z, 2);
        	
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_garrison
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_garrison) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_garrison.name";
        	 this.flag_range = 20;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_garrison) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_garrison;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_garrison;
            }
           
        	this.Mob_spawn(x, y, z, 0);
            /////////////////////////
        }
        
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_metro
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_metro) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_metro.name";
        	 this.base_boss = false;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_metro) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_metro;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_metro;
            }
           
        	this.Mob_spawn(x, y, z, 1);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_cannon_position
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_cannon_position) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_cannon_position.name";
        	 this.base_boss = false;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_cannon_position) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_cannon_position;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_cannon_position;
            }
           
        	this.Mob_spawn(x, y, z, 1);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_trench
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_trench) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_trench.name";
        	 this.flag_range = 20;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_trench) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_trench;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_trench;
            }
           
        	this.Mob_spawn(x, y, z, 1);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_battleship
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_battleship) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_battleship.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_battleship) {
            	enemy = true; 
            	invmaxcount = 600;
            	inv_tex = "inv_m.png";
                inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_battleship;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_battleship;
            }
           
        	this.Mob_spawn(x, y, z, 1);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_snowcastle
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_snowcastle) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_snowcastle.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_snowcastle) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_snowcastle;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_snowcastle;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_trainstation
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_trainstation) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_trainstation.name";
        	 this.base_boss = true;
        	 this.flag_range = 20;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_trainstation) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_trainstation;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_trainstation;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_reichstag
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_reichstag) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_reichstag.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_reichstag) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_reichstag;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_reichstag;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_desertcity
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_desertcity) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_desertcity.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_desertcity) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_desertcity;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_desertcity;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_cv
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_cv) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_cv.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	 this.can_under_mob = false;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_cv) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_cv;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_cv;
            }
           
        	if(jamming(x, y, z, 100)) {
        		if(enemyblock) {
        			invcount = 0;
        		}
        	}
        	
        	
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_dd
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_dd) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_dd.name";
        	 this.base_boss = false;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_dd) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_dd;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_dd;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ff
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_ff) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_ff.name";
        	 this.base_boss = false;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ff) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_ff;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_ff;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_triumphal_arch
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_triumphal_arch) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_triumphal_arch.name";
        	 this.base_boss = true;
        	 this.flag_range = 10;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_triumphal_arch) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_triumphal_arch;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_triumphal_arch;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_flaktower
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_flaktower) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_flaktower.name";
        	 this.base_boss = true;
        	 this.flag_range = 6;
        	 this.spawn_inv_timing = false;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_flaktower) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_flaktower;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_flaktower;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_slum
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_slum) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_slum.name";
        	 this.base_boss = true;
        	 this.flag_range = 6;
        	 this.spawn_inv_timing = false;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_slum) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_slum;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_slum;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_highway
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_so_highway) {
        	/////////////////////////
        	 this.inv_name = "gvcr2.gvcr2_block_flag_highway.name";
        	 this.base_boss = true;
        	 this.flag_range = 6;
        	 this.spawn_inv_timing = false;
        	if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_highway) {
            	enemy = true; 
            	invmaxcount = 600;
                 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = true;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_so_highway;
            }else {
            	 enemy = false;
            	 invmaxcount = 600;
            	 inv_tex = "inv_m.png";
                 inv_tex_em = "inv_m_em.png";
                 enemyblock = false;
                 invclearblock = mod_GVCR2.gvcr2_block_flag_ge_highway;
            }
           
        	this.Mob_spawn(x, y, z, 2);
            /////////////////////////
        }
        
        
        
	}
    
    protected void Invation(BlockPos pos) {
    	super.Invation(pos);
    	if(!this.base_boss) {
    		if(mod_GVCR2.difficult_level < 4)GVCR2WorldDifficultyLevel.setLevel(mod_GVCR2.INSTANCE, world, 4, "levelUp4");
    	}else {
    		if(mod_GVCR2.difficult_level < 6)GVCR2WorldDifficultyLevel.setLevel(mod_GVCR2.INSTANCE, world, 6, "levelUp6");
    	}
    	
    	int x = this.pos.getX();
        int y= this.pos.getY();
        int z = this.pos.getZ();
    	
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_city
        		|| this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ship) {
        	for(int xx = 0; xx < 128; ++xx) {
            	for(int yy = 0; yy < 40; ++yy) {
            		for(int zz = 0; zz < 128; ++zz) {
            			if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_city) {
            				if(this.world.getBlockState(new BlockPos(x + xx - 64, y + yy - 20, z + zz - 64)).getBlock() == mod_GVCR2.gvcr2_block_boss_st1) {
            					TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world.getTileEntity(new BlockPos(x + xx - 64, y + yy - 20, z + zz - 64));
            					tile.spawn = true;
            				}
            			}
            			if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_ship) {
            				if(this.world.getBlockState(new BlockPos(x + xx - 64, y + yy - 20, z + zz - 64)).getBlock() == mod_GVCR2.gvcr2_block_boss_longleg) {
            					TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world.getTileEntity(new BlockPos(x + xx - 64, y + yy - 20, z + zz - 64));
            					tile.spawn = true;
            				}
            			}
            			if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_reichstag) {
            				if(this.world.getBlockState(new BlockPos(x + xx - 64, y + yy - 40, z + zz - 64)).getBlock() == mod_GVCR2.gvcr2_block_boss_hauneb) {
            					TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world.getTileEntity(new BlockPos(x + xx - 64, y + yy - 40, z + zz - 64));
            					tile.spawn = true;
            				}
            			}
            		}
    			}
        	}
        }
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_reichstag) {
        	for(int xx = 0; xx < 256; ++xx) {
            	for(int yy = 0; yy < 60; ++yy) {
            		for(int zz = 0; zz < 256; ++zz) {
            			if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_reichstag) {
            				if(this.world.getBlockState(new BlockPos(x + xx - 128, y + yy - 40, z + zz - 128)).getBlock() == mod_GVCR2.gvcr2_block_boss_hauneb) {
            					TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world.getTileEntity(new BlockPos(x + xx - 128, y + yy - 40, z + zz - 128));
            					tile.spawn = true;
            				}
            			}
            		}
    			}
        	}
        }
        
        if(this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_desertcity) {
        	for(int xx = 0; xx < 256; ++xx) {
            	for(int yy = 0; yy < 60; ++yy) {
            		for(int zz = 0; zz < 256; ++zz) {
            			{
            				if(this.world.getBlockState(new BlockPos(x + xx - 128, y + yy - 40, z + zz - 128)).getBlock() == mod_GVCR2.gvcr2_block_boss_irving) {
            					TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world.getTileEntity(new BlockPos(x + xx - 128, y + yy - 40, z + zz - 128));
            					tile.spawn = true;
            				}
            			}
            		}
    			}
        	}
        }
        
		if (this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_cv) {
			if (this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == mod_GVCR2.gvcr2_block_flag_boss_cv) {
				TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world
						.getTileEntity(new BlockPos(x, y + 1, z));
				tile.spawn = true;
			}
		}
		if (this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_triumphal_arch) {
			if (this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_char2c) {
				TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world
						.getTileEntity(new BlockPos(x, y + 1, z));
				tile.spawn = true;
			}
		}
		if (this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_flaktower) {
			if (this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_mer08_b) {
				TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world
						.getTileEntity(new BlockPos(x, y + 1, z));
				tile.spawn = true;
			}
		}
		if (this.world.getBlockState(this.pos).getBlock() == mod_GVCR2.gvcr2_block_flag_ge_highway) {
			if (this.world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == mod_GVCR2.gvcr2_block_boss_av8b) {
				TileEntityBlockBossSpawn_Tile tile = (TileEntityBlockBossSpawn_Tile) world
						.getTileEntity(new BlockPos(x, y + 1, z));
				tile.spawn = true;
			}
		}
    	
    }
    
    
    private void Mob_spawn(int x, int y, int z, int scale) {
    	if(enemy) {
        	++count;
            if(count > 400) {
    			if (this.canspawn(x, y, z, 20) && !this.world.isRemote) {
    				
    				int i = this.world.rand.nextInt(5) + 1;
    		        for(int ii = 0; ii < i; ++ii){
    		        	int ix = this.world.rand.nextInt(10);
    					int iz = this.world.rand.nextInt(10);
    					BlockPos spawnpos = new BlockPos(x - 5 + ix, y + 1, z - 5 + iz);
    					BlockPos spawnpos2 = new BlockPos(x - 5 + ix, y + 2, z - 5 + iz);
    					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
    							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
    						EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
        		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        		        	entityskeleton.setWeapon(true);
        			        this.world.spawnEntity(entityskeleton);
    					}
    		        }
    		        if(this.world.rand.nextInt(2) == 0 && spawn_heli) {
    		        	BlockPos spawnpos = new BlockPos(x, y + 2, z);
    					{
    						EntityGVCR2_HELI_R22 entityskeleton = new EntityGVCR2_HELI_R22(this.world);
    						entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        			        this.world.spawnEntity(entityskeleton);
        			        {
        			        	EntityGVCR2_GE_S entityskeleton2 = new EntityGVCR2_GE_S(this.world);
          				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
          				       this.world.spawnEntity(entityskeleton2);
          				     entityskeleton2.startRiding(entityskeleton);
        			        }
    					}
    		        }
    		        if(this.world.rand.nextInt(2) == 0 && spawn_tank) {
    		        	BlockPos spawnpos = new BlockPos(x, y + 2, z);
    					{
    						EntityGVCR2_TANK_T34 entityskeleton = new EntityGVCR2_TANK_T34(this.world);
    						entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        			        this.world.spawnEntity(entityskeleton);
        			        {
        			        	EntityGVCR2_GE_S entityskeleton2 = new EntityGVCR2_GE_S(this.world);
          				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
          				       this.world.spawnEntity(entityskeleton2);
          				     entityskeleton2.startRiding(entityskeleton);
        			        }
    					}
    		        }
    			}
    			count = 0;
            }
        }
    	else {
    		++count;
            if(count > 400) {
    			if (this.canspawnAlly(x, y, z, 16) && !this.world.isRemote) {
    				int i = this.world.rand.nextInt(5) + 1;
    		        for(int ii = 0; ii < i; ++ii){
    		        	int ix = this.world.rand.nextInt(10);
    					int iz = this.world.rand.nextInt(10);
    					BlockPos spawnpos = new BlockPos(x - 5 + ix, y + 1, z - 5 + iz);
    					BlockPos spawnpos2 = new BlockPos(x - 5 + ix, y + 2, z - 5 + iz);
    					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
    							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
    						EntityGVCR2_SO_S entityskeleton = new EntityGVCR2_SO_S(this.world);
        		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        		        	entityskeleton.setWeapon_base();
        			        this.world.spawnEntity(entityskeleton);
    					}
    		        }
    		        if(this.world.rand.nextInt(2) == 0 && spawn_heli) {
    		        	BlockPos spawnpos = new BlockPos(x, y + 2, z);
    					{
    						EntityGVCR2_HELI_AH1S entityskeleton = new EntityGVCR2_HELI_AH1S(this.world);
    						entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        			        this.world.spawnEntity(entityskeleton);
        			        {
        			        	EntityGVCR2_SO_S entityskeleton2 = new EntityGVCR2_SO_S(this.world);
          				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
          				       this.world.spawnEntity(entityskeleton2);
          				     entityskeleton2.startRiding(entityskeleton);
        			        }
    					}
    		        }
    		        if(this.world.rand.nextInt(2) == 0 && spawn_tank) {
    		        	BlockPos spawnpos = new BlockPos(x, y + 2, z);
    					{
    						EntityGVCR2_TANK_M60A1 entityskeleton = new EntityGVCR2_TANK_M60A1(this.world);
    						entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        			        this.world.spawnEntity(entityskeleton);
        			        {
        			        	EntityGVCR2_SO_S entityskeleton2 = new EntityGVCR2_SO_S(this.world);
          				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
          				       this.world.spawnEntity(entityskeleton2);
          				     entityskeleton2.startRiding(entityskeleton);
        			        }
    					}
    		        }
    			}
    			count = 0;
            }
    		/*if(this.world.getWorldTime() == 13050 && this.world.rand.nextInt(2) == 0) {
    			if (!this.world.isRemote) {
    				
    				int rando = this.world.rand.nextInt(4);
					int randX = 0;
					int randZ = 0;
					if(rando == 0) {
						randX = 120;
						randZ = 0;
					}
					else if(rando == 1) {
						randX = -120;
						randZ = 0;
					}
					else if(rando == 2) {
						randX = 0;
						randZ = 120;
					}
					else{
						randX = 0;
						randZ = -120;
					}
					
					int i = this.world.rand.nextInt(5) + 4;
    		        for(int ii = 0; ii < i; ++ii){
    		        	int ix = this.world.rand.nextInt(20);
    					int iz = this.world.rand.nextInt(20);
    					int XX = x - 10 + ix + randX;
    					int ZZ = z - 10 + iz + randZ;
    					BlockPos spawnpos0 = world.getHeight(new BlockPos(x - 10 + ix - 40, y + 1, z - 10 + iz));
    					int heightY = spawnpos0.getY();
    					BlockPos spawnpos = new BlockPos(XX, heightY + 1, ZZ);
    					BlockPos spawnpos2 = new BlockPos(XX, heightY + 2, ZZ);
    					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
    							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
    						EntityGVCR2_GE_S entityskeleton = new EntityGVCR2_GE_S(this.world);
        		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        		        	entityskeleton.setWeapon(true);
        		        	entityskeleton.setcanDespawn(1);
        					entityskeleton.setMoveT(1);
        					entityskeleton.setMoveX(x);
        					entityskeleton.setMoveY(y);
        					entityskeleton.setMoveZ(z);
        			        this.world.spawnEntity(entityskeleton);
    					}
    		        }
    		        if(mod_GVCR2.difficult_level >= 1 && scale != 1) {
    		        	int i2 = this.world.rand.nextInt(2) + 2;
        		        for(int ii = 0; ii < i2; ++ii){
        		        	int ix = this.world.rand.nextInt(20);
        					int iz = this.world.rand.nextInt(20);
        					int XX = x - 10 + ix + randX;
        					int ZZ = z - 10 + iz + randZ;
        					BlockPos spawnpos0 = world.getHeight(new BlockPos(x - 10 + ix - 40, y + 1, z - 10 + iz));
        					int heightY = spawnpos0.getY();
        					BlockPos spawnpos = new BlockPos(XX, heightY + 1, ZZ);
        					BlockPos spawnpos2 = new BlockPos(XX, heightY + 2, ZZ);
        					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
        							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
        						EntityGVCR2_CAR_Technical entityskeleton = new EntityGVCR2_CAR_Technical(this.world);
            		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
            		        	entityskeleton.setcanDespawn(1);
            					entityskeleton.setMoveT(1);
            					entityskeleton.setMoveX(x);
            					entityskeleton.setMoveY(y);
            					entityskeleton.setMoveZ(z);
            			        this.world.spawnEntity(entityskeleton);
            			        
            			        for(int ii1 = 0; ii1 < 3; ++ii1){
            			        	EntityGVCR2_GE_S entityskeleton2 = new EntityGVCR2_GE_S(this.world);
              				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
              				       entityskeleton2.setcanDespawn(1);
              				       entityskeleton2.setMoveT(1);
              				       entityskeleton2.setMoveX(x);
              				       entityskeleton2.setMoveY(y);
              				       entityskeleton2.setMoveZ(z);
              				       entityskeleton2.setcanDespawn(1);
              				       this.world.spawnEntity(entityskeleton2);
              				     entityskeleton2.startRiding(entityskeleton);
            			        }
        					}
        		        }
        		        int ix = this.world.rand.nextInt(20);
    					int iz = this.world.rand.nextInt(20);
    					int XX = x - 10 + ix + randX;
    					int ZZ = z - 10 + iz + randZ;
    					BlockPos spawnpos0 = world.getHeight(new BlockPos(x - 10 + ix - 40, y + 1, z - 10 + iz));
    					int heightY = spawnpos0.getY();
    					BlockPos spawnpos = new BlockPos(XX, heightY + 1, ZZ);
    					BlockPos spawnpos2 = new BlockPos(XX, heightY + 2, ZZ);
    					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
    							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
    						EntityGVCR2_TANK_PT76 entityskeleton = new EntityGVCR2_TANK_PT76(this.world);
        		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        		        	entityskeleton.setcanDespawn(1);
        					entityskeleton.setMoveT(1);
        					entityskeleton.setMoveX(x);
        					entityskeleton.setMoveY(y);
        					entityskeleton.setMoveZ(z);
        			        this.world.spawnEntity(entityskeleton);
        			        
        			       EntityGVCR2_GE_S entityskeleton2 = new EntityGVCR2_GE_S(this.world);
     				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
     				       entityskeleton2.setcanDespawn(1);
     				       entityskeleton2.setMoveT(1);
     				       entityskeleton2.setMoveX(x);
     				       entityskeleton2.setMoveY(y);
     				       entityskeleton2.setMoveZ(z);
     				       entityskeleton2.setcanDespawn(1);
     				       this.world.spawnEntity(entityskeleton2);
     				   entityskeleton2.startRiding(entityskeleton);
    					}
    		        }
    		        if(mod_GVCR2.difficult_level >= 2 && scale >= 2) {
    		        	int i2 = this.world.rand.nextInt(2) + 1;
        		        for(int ii = 0; ii < i2; ++ii){
        		        	int ix = this.world.rand.nextInt(20);
        					int iz = this.world.rand.nextInt(20);
        					int XX = x - 10 + ix + randX;
        					int ZZ = z - 10 + iz + randZ;
        					BlockPos spawnpos0 = world.getHeight(new BlockPos(x - 10 + ix - 40, y + 1, z - 10 + iz));
        					int heightY = spawnpos0.getY();
        					BlockPos spawnpos = new BlockPos(XX, heightY + 1, ZZ);
        					BlockPos spawnpos2 = new BlockPos(XX, heightY + 2, ZZ);
        					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
        							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
        						EntityGVCR2_TANK_PT76 entityskeleton = new EntityGVCR2_TANK_PT76(this.world);
            		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
            		        	entityskeleton.setcanDespawn(1);
            					entityskeleton.setMoveT(1);
            					entityskeleton.setMoveX(x);
            					entityskeleton.setMoveY(y);
            					entityskeleton.setMoveZ(z);
            			        this.world.spawnEntity(entityskeleton);
            			        
            			       EntityGVCR2_GE_S entityskeleton2 = new EntityGVCR2_GE_S(this.world);
         				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
         				       entityskeleton2.setcanDespawn(1);
         				       entityskeleton2.setMoveT(1);
         				       entityskeleton2.setMoveX(x);
         				       entityskeleton2.setMoveY(y);
         				       entityskeleton2.setMoveZ(z);
         				       entityskeleton2.setcanDespawn(1);
         				       this.world.spawnEntity(entityskeleton2);
         				   entityskeleton2.startRiding(entityskeleton);
        					}
        		        }
        		        int ix = this.world.rand.nextInt(20);
    					int iz = this.world.rand.nextInt(20);
    					int XX = x - 10 + ix + randX;
    					int ZZ = z - 10 + iz + randZ;
    					BlockPos spawnpos0 = world.getHeight(new BlockPos(x - 10 + ix - 40, y + 1, z - 10 + iz));
    					int heightY = spawnpos0.getY();
    					BlockPos spawnpos = new BlockPos(XX, heightY + 1, ZZ);
    					BlockPos spawnpos2 = new BlockPos(XX, heightY + 2, ZZ);
    					if(this.world.getBlockState(spawnpos).getBlock() == Blocks.AIR
    							&& this.world.getBlockState(spawnpos2).getBlock() == Blocks.AIR) {
    						EntityGVCR2_TANK_T34 entityskeleton = new EntityGVCR2_TANK_T34(this.world);
        		        	entityskeleton.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
        		        	entityskeleton.setcanDespawn(1);
        					entityskeleton.setMoveT(1);
        					entityskeleton.setMoveX(x);
        					entityskeleton.setMoveY(y);
        					entityskeleton.setMoveZ(z);
        			        this.world.spawnEntity(entityskeleton);
        			        
        			       EntityGVCR2_GE_S entityskeleton2 = new EntityGVCR2_GE_S(this.world);
     				       entityskeleton2.setLocationAndAngles(spawnpos.getX(), spawnpos.getY(), spawnpos.getZ(), 0, 0.0F);
     				       entityskeleton2.setcanDespawn(1);
     				       entityskeleton2.setMoveT(1);
     				       entityskeleton2.setMoveX(x);
     				       entityskeleton2.setMoveY(y);
     				       entityskeleton2.setMoveZ(z);
     				       entityskeleton2.setcanDespawn(1);
     				       this.world.spawnEntity(entityskeleton2);
     				   entityskeleton2.startRiding(entityskeleton);
    					}
    		        }
    		        
    		        
    			}
    			EntityPlayer player = mod_GVCR2.proxy.getEntityPlayerInstance();
				if(player != null) {
					if (this.world.isRemote)player.sendMessage(new TextComponentTranslation("MOB INV!", new Object[0]));
				}
    		}*/
        }
    }
    
    public boolean jamming(double x, double y, double z, int han) {
    	boolean spawn = false;
    	Entity entity = null;
    	int mobkazu = 0;
    	int mobkazu2 = 0;
    	{
    		AxisAlignedBB axisalignedbb2 = (new AxisAlignedBB((double)(x-han), (double)(y-han), (double)(z-han), (double)(x + han), (double)(y + han), (double)(z+ han)))
            		.grow(1);
            List llist2 = this.world.getEntitiesWithinAABBExcludingEntity(entity, axisalignedbb2);
            if(llist2!=null){
                for (int lj = 0; lj < llist2.size(); lj++) {
                	
                	Entity entity1 = (Entity)llist2.get(lj);
                	if (entity1.canBeCollidedWith())
                    {
                		if (entity1 instanceof EntityLivingBase && entity1 != null) {
    						if (entity1 instanceof EntityGVCR2_GE_Jamming) {
    							++mobkazu2;
    							if(this.world.getWorldTime() %400 == 0) {
    								EntityLivingBase en = (EntityLivingBase) entity1; 
    								en.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100, 100));
    							}
    						}
    					}
                    }
                }
            }
    	}
    	if(mobkazu2 > 0) {
    		spawn = true;
    	}
    	return spawn;
    }
}