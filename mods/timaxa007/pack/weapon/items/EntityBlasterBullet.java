package mods.timaxa007.pack.weapon.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlasterBullet extends Entity implements IProjectile{
private int xTile=-1;
private int yTile=-1;
private int zTile=-1;
private int inTile;
private int inData;
private boolean inGround;

/** 1 if the player can pick up the arrow */
public int canBePickedUp;

/** Seems to be some sort of timer for animating an arrow. */
public int arrowShake;

/** The owner of this arrow. */
public Entity shootingEntity;
private int ticksInGround;
private int ticksInAir;

public EntityBlasterBullet(World par1World, EntityLivingBase par2EntityLivingBaseBase, float par3) {
super(par1World);
this.renderDistanceWeight=10.0D;
this.shootingEntity=par2EntityLivingBaseBase;

if(par2EntityLivingBaseBase instanceof EntityPlayer) {
this.canBePickedUp=1;
}

this.setSize(0.5F, 0.5F);
this.setLocationAndAngles(par2EntityLivingBaseBase.posX, par2EntityLivingBaseBase.posY+(double)par2EntityLivingBaseBase.getEyeHeight(), par2EntityLivingBaseBase.posZ, par2EntityLivingBaseBase.rotationYaw, par2EntityLivingBaseBase.rotationPitch);
this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
this.posY -= 0.10000000149011612D;
this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
this.setPosition(this.posX, this.posY, this.posZ);
this.yOffset=0.0F;
this.motionX=(double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
this.motionZ=(double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
this.motionY=(double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
}

	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
		float f2=MathHelper.sqrt_double(par1 * par1+par3 * par3+par5 * par5);
par1 /= (double)f2;
par3 /= (double)f2;
par5 /= (double)f2;
par1 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
par3 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
par5 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
par1 *= (double)par7;
par3 *= (double)par7;
par5 *= (double)par7;
this.motionX=par1;
this.motionY=par3;
this.motionZ=par5;
float f3=MathHelper.sqrt_double(par1 * par1+par5 * par5);
this.prevRotationYaw=this.rotationYaw=(float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
this.prevRotationPitch=this.rotationPitch=(float)(Math.atan2(par3, (double)f3) * 180.0D / Math.PI);
this.ticksInGround=0;
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		this.xTile=par1NBTTagCompound.getShort("xTile");
this.yTile=par1NBTTagCompound.getShort("yTile");
this.zTile=par1NBTTagCompound.getShort("zTile");
this.inTile=par1NBTTagCompound.getByte("inTile") & 255;
this.inData=par1NBTTagCompound.getByte("inData") & 255;
this.arrowShake=par1NBTTagCompound.getByte("shake") & 255;
this.inGround=par1NBTTagCompound.getByte("inGround")==1;

if(par1NBTTagCompound.hasKey("pickup")) {
this.canBePickedUp=par1NBTTagCompound.getByte("pickup");
}
else if(par1NBTTagCompound.hasKey("player")) {
this.canBePickedUp=par1NBTTagCompound.getBoolean("player") ? 1 : 0;
}
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("xTile", (short)this.xTile);
par1NBTTagCompound.setShort("yTile", (short)this.yTile);
par1NBTTagCompound.setShort("zTile", (short)this.zTile);
par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
par1NBTTagCompound.setByte("inData", (byte)this.inData);
par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
	}
	
	public void setVelocity(double par1, double par3, double par5) {
this.motionX=par1;
this.motionY=par3;
this.motionZ=par5;

if(this.prevRotationPitch==0.0F && this.prevRotationYaw==0.0F) {
float f=MathHelper.sqrt_double(par1 * par1+par5 * par5);
this.prevRotationYaw=this.rotationYaw=(float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
this.prevRotationPitch=this.rotationPitch=(float)(Math.atan2(par3, (double)f) * 180.0D / Math.PI);
this.prevRotationPitch=this.rotationPitch;
this.prevRotationYaw=this.rotationYaw;
this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
this.ticksInGround=0;
}
}
	
	public boolean isInvulnerable() {
return this.dataWatcher.getWatchableObjectByte(10)==1;
}
	
	public void onUpdate() {
		super.onUpdate();

if(this.prevRotationPitch==0.0F && this.prevRotationYaw==0.0F) {
float f=MathHelper.sqrt_double(this.motionX * this.motionX+this.motionZ * this.motionZ);
this.prevRotationYaw=this.rotationYaw=(float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
this.prevRotationPitch=this.rotationPitch=(float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
}

int i=this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);

if(i > 0) {
Block.blocksList[i].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
AxisAlignedBB axisalignedbb=Block.blocksList[i].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 10.0F, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
this.setDead();
}

if(this.arrowShake > 0) {
--this.arrowShake;
}

if(this.inGround) {
int j=this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
int k=this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

if(j==this.inTile && k==this.inData) {
++this.ticksInGround;

if(this.ticksInGround==1200) {
this.setDead();
}
}
else{
this.inGround=false;
this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
this.ticksInGround=0;
this.ticksInAir=0;
}
}
else{
++this.ticksInAir;
Vec3 vec3=this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
Vec3 vec31=this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX+this.motionX, this.posY+this.motionY, this.posZ+this.motionZ);
MovingObjectPosition movingobjectposition=this.worldObj.rayTraceBlocks_do_do(vec3, vec31, false, true);
vec3=this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
vec31=this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX+this.motionX, this.posY+this.motionY, this.posZ+this.motionZ);

if(movingobjectposition != null) {
vec31=this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
}

Entity entity=null;
List list=this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
double d0=0.0D;
int l;
float f1;

if(movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
EntityPlayer entityplayer=(EntityPlayer)movingobjectposition.entityHit;

if(entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).interactFirst(entityplayer)) {
movingobjectposition=null;
}
}

float f2;
float f3;

if(movingobjectposition != null) {
if(movingobjectposition.entityHit != null) {
f2=MathHelper.sqrt_double(this.motionX * this.motionX+this.motionY * this.motionY+this.motionZ * this.motionZ);
int i1=MathHelper.ceiling_double_int((double)f2);

if(this.isBurning() && !(movingobjectposition.entityHit instanceof EntityEnderman)) {
movingobjectposition.entityHit.setFire(5);
}
else{
this.motionX *= -0.10000000149011612D;
this.motionY *= -0.10000000149011612D;
this.motionZ *= -0.10000000149011612D;
this.rotationYaw += 180.0F;
this.prevRotationYaw += 180.0F;
this.ticksInAir=0;
}
}
else{
this.xTile=movingobjectposition.blockX;
this.yTile=movingobjectposition.blockY;
this.zTile=movingobjectposition.blockZ;
this.inTile=this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
this.inData=this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
this.motionX=(double)((float)(movingobjectposition.hitVec.xCoord-this.posX));
this.motionY=(double)((float)(movingobjectposition.hitVec.yCoord-this.posY));
this.motionZ=(double)((float)(movingobjectposition.hitVec.zCoord-this.posZ));
f2=MathHelper.sqrt_double(this.motionX * this.motionX+this.motionY * this.motionY+this.motionZ * this.motionZ);
this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F+0.9F));
this.inGround=true;
this.arrowShake=7;

if(this.inTile != 0) {
Block.blocksList[this.inTile].onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
}
}
}

this.posX += this.motionX;
this.posY += this.motionY;
this.posZ += this.motionZ;
f2=MathHelper.sqrt_double(this.motionX * this.motionX+this.motionZ * this.motionZ);
this.rotationYaw=(float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

float f4=0.99F;
f1=0.00F;

if(this.isInWater()) {
for(byte j1=0;j1<4;++j1) {
f3=0.25F;
this.worldObj.spawnParticle("bubble", this.posX-this.motionX * (double)f3, this.posY-this.motionY * (double)f3, this.posZ-this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
}

f4=0.8F;
}

this.motionX *= (double)f4;
this.motionY *= (double)f4;
this.motionZ *= (double)f4;
this.motionY -= (double)f1;
this.setPosition(this.posX, this.posY, this.posZ);
this.doBlockCollisions();
}
}
	
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
if(!this.worldObj.isRemote) {
if(par1MovingObjectPosition.entityHit != null) {
if(this.shootingEntity != null) {

}
else{
par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.magic, (int) 5.0F);
}

if(par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
byte b0=0;

if(this.worldObj.difficultySetting > 1) {
if(this.worldObj.difficultySetting==2) {
b0=10;
}
else if(this.worldObj.difficultySetting==3) {
b0=40;
}
}

if(b0 > 0) {
((EntityLivingBase)par1MovingObjectPosition.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 20 * b0, 1));
}
}
}

this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
this.setDead();
}
}
}