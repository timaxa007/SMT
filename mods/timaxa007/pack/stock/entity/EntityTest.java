package mods.timaxa007.pack.stock.entity;

import java.util.Calendar;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDummyContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTest extends EntityMob {

protected static final Attribute field_110186_bp = (new RangedAttribute("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).func_111117_a("Spawn Reinforcements Chance");
private static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5D, 1);

public EntityTest(World wrd) {
super(wrd);
this.getNavigator().setBreakDoors(true);
this.tasks.addTask(0, new EntityAISwimming(this));
this.tasks.addTask(1, new EntityAIBreakDoor(this));
this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
this.tasks.addTask(7, new EntityAILookIdle(this));
this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
}

protected void applyEntityAttributes() {
super.applyEntityAttributes();
this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.23000000417232513D);
this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(3.0D);
this.getAttributeMap().func_111150_b(field_110186_bp).setAttribute(this.rand.nextDouble() * ForgeDummyContainer.zombieSummonBaseChance);
}

protected void entityInit() {
super.entityInit();
this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
}

public int getTotalArmorValue() {
int i = super.getTotalArmorValue() + 2;
if(i > 20) {i = 20;}
return i;
}

protected boolean isAIEnabled() {
return true;
}

public boolean isChild() {
return this.getDataWatcher().getWatchableObjectByte(12) == 1;
}

public void setChild(boolean par1) {
this.getDataWatcher().updateObject(12, Byte.valueOf((byte)(par1 ? 1 : 0)));

if(this.worldObj != null && !this.worldObj.isRemote) {
AttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
attributeinstance.removeModifier(babySpeedBoostModifier);

if(par1) {
attributeinstance.applyModifier(babySpeedBoostModifier);
}
}
}

public boolean isVillager() {
return this.getDataWatcher().getWatchableObjectByte(13) == 1;
}

public void setVillager(boolean par1) {
this.getDataWatcher().updateObject(13, Byte.valueOf((byte)(par1 ? 1 : 0)));
}

public void onLivingUpdate() {
if(this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()) {
float f = this.getBrightness(1.0F);

if(f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
boolean flag = true;
ItemStack itemstack = this.getCurrentItemOrArmor(4);

if(itemstack != null) {
if(itemstack.isItemStackDamageable()) {
itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));

if(itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage()) {
this.renderBrokenItemStack(itemstack);
this.setCurrentItemOrArmor(4, (ItemStack)null);
}
}

flag = false;
}

if(flag) {this.setFire(8);}
}
}

super.onLivingUpdate();
}

public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
if(!super.attackEntityFrom(par1DamageSource, par2)) {
return false;
}else{
EntityLivingBase entitylivingbase = this.getAttackTarget();

if(entitylivingbase == null && this.getEntityToAttack() instanceof EntityLivingBase) {
entitylivingbase = (EntityLivingBase)this.getEntityToAttack();
}

if(entitylivingbase == null && par1DamageSource.getEntity() instanceof EntityLivingBase) {
entitylivingbase = (EntityLivingBase)par1DamageSource.getEntity();
}

int i = MathHelper.floor_double(this.posX);
int j = MathHelper.floor_double(this.posY);
int k = MathHelper.floor_double(this.posZ);

//SummonAidEvent summonAid = ForgeEventFactory.fireZombieSummonAid(this, worldObj, i, j, k, entitylivingbase, this.getEntityAttribute(field_110186_bp).getAttributeValue());
/*
if(summonAid.getResult() == Result.DENY) {return true;}
else if(summonAid.getResult() == Result.ALLOW || entitylivingbase != null && this.worldObj.difficultySetting >= 3 && (double)this.rand.nextFloat() < this.getEntityAttribute(field_110186_bp).getAttributeValue()) {
EntityZombie entityzombie;
if(summonAid.customSummonedAid != null && summonAid.getResult() == Result.ALLOW) {
entityzombie = summonAid.customSummonedAid;
}
else{
entityzombie = new EntityZombie(this.worldObj);
}
*/
for(int l = 0;l < 50;++l) {
int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
/*
if(this.worldObj.doesBlockHaveSolidTopSurface(i1, j1 - 1, k1) && this.worldObj.getBlockLightValue(i1, j1, k1) < 10) {
entityzombie.setPosition((double)i1, (double)j1, (double)k1);

if(this.worldObj.checkNoEntityCollision(entityzombie.boundingBox) && this.worldObj.getCollidingBoundingBoxes(entityzombie, entityzombie.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(entityzombie.boundingBox)) {
this.worldObj.spawnEntityInWorld(entityzombie);
if(entitylivingbase != null) entityzombie.setAttackTarget(entitylivingbase);
entityzombie.onSpawnWithEgg((EntityLivingData)null);
this.getEntityAttribute(field_110186_bp).applyModifier(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
entityzombie.getEntityAttribute(field_110186_bp).applyModifier(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
break;
}
}
}*/
}

return true;
}
}

/**
 * Called to update the entity's position/logic.
 */
public void onUpdate() {
/*
if(!this.worldObj.isRemote && this.isConverting()) {
int i = this.getConversionTimeBoost();
this.conversionTime -= i;

if(this.conversionTime <= 0) {
this.convertToVillager();
}
}
*/
super.onUpdate();
}

public boolean attackEntityAsMob(Entity par1Entity) {
boolean flag = super.attackEntityAsMob(par1Entity);

if(flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3F) {
par1Entity.setFire(2 * this.worldObj.difficultySetting);
}

return flag;
}

protected String getLivingSound() {
return "mob.zombie.say";
}

protected String getHurtSound() {
return "mob.zombie.hurt";
}

protected String getDeathSound() {
return "mob.zombie.death";
}

protected void playStepSound(int par1, int par2, int par3, int par4) {
this.playSound("mob.zombie.step", 0.15F, 1.0F);
}

protected int getDropItemId() {
return Item.rottenFlesh.itemID;
}

public EnumCreatureAttribute getCreatureAttribute() {
return EnumCreatureAttribute.UNDEAD;
}

protected void dropRareDrop(int par1) {
switch(this.rand.nextInt(3)) {
case 0:
this.dropItem(Item.ingotIron.itemID, 1);
break;
case 1:
this.dropItem(Item.carrot.itemID, 1);
break;
case 2:
this.dropItem(Item.potato.itemID, 1);
}
}

/**
 * Makes entity wear random armor based on difficulty
 */
protected void addRandomArmor() {
super.addRandomArmor();

if(this.rand.nextFloat() < (this.worldObj.difficultySetting == 3 ? 0.05F : 0.01F)) {
int i = this.rand.nextInt(3);

if(i == 0) {
this.setCurrentItemOrArmor(0, new ItemStack(Item.swordIron));
}else{
this.setCurrentItemOrArmor(0, new ItemStack(Item.shovelIron));
}
}
}

public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
super.writeEntityToNBT(par1NBTTagCompound);

if(this.isChild()) {
par1NBTTagCompound.setBoolean("IsBaby", true);
}

if(this.isVillager()) {
par1NBTTagCompound.setBoolean("IsVillager", true);
}

//par1NBTTagCompound.setInteger("ConversionTime", this.isConverting() ? this.conversionTime : -1);
}

public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
super.readEntityFromNBT(par1NBTTagCompound);

if(par1NBTTagCompound.getBoolean("IsBaby")) {
this.setChild(true);
}

if(par1NBTTagCompound.getBoolean("IsVillager")) {
this.setVillager(true);
}

if(par1NBTTagCompound.hasKey("ConversionTime") && par1NBTTagCompound.getInteger("ConversionTime") > -1) {
this.startConversion(par1NBTTagCompound.getInteger("ConversionTime"));
}
}

public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
super.onKillEntity(par1EntityLivingBase);

if(this.worldObj.difficultySetting >= 2 && par1EntityLivingBase instanceof EntityVillager) {
if(this.worldObj.difficultySetting == 2 && this.rand.nextBoolean()) {
return;
}

EntityZombie entityzombie = new EntityZombie(this.worldObj);
entityzombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
this.worldObj.removeEntity(par1EntityLivingBase);
entityzombie.onSpawnWithEgg((EntityLivingData)null);
entityzombie.setVillager(true);

if(par1EntityLivingBase.isChild()) {
entityzombie.setChild(true);
}

this.worldObj.spawnEntityInWorld(entityzombie);
this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
}
}

public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData) {
Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);
float f = this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ);
this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
/*
if(par1EntityLivingData1 == null) {
par1EntityLivingData1 = new EntityZombieGroupData(this, this.worldObj.rand.nextFloat() < ForgeDummyContainer.zombieBabyChance, this.worldObj.rand.nextFloat() < 0.05F, (EntityZombieINNER1)null);
}

if(par1EntityLivingData1 instanceof EntityZombieGroupData) {
EntityZombieGroupData entityzombiegroupdata = (EntityZombieGroupData)par1EntityLivingData1;

if(entityzombiegroupdata.field_142046_b) {
this.setVillager(true);
}

if(entityzombiegroupdata.field_142048_a) {
this.setChild(true);
}
}
*/
this.addRandomArmor();
this.enchantEquipment();

if(this.getCurrentItemOrArmor(4) == null) {
Calendar calendar = this.worldObj.getCurrentDate();

if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F) {
this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern : Block.pumpkin));
this.equipmentDropChances[4] = 0.0F;
}
}

this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random zombie-spawn bonus", this.rand.nextDouble() * 1.5D, 2));

if(this.rand.nextFloat() < f * 0.05F) {
this.getEntityAttribute(field_110186_bp).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
this.getEntityAttribute(SharedMonsterAttributes.maxHealth).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
}

return (EntityLivingData)par1EntityLivingData1;
}

public boolean interact(EntityPlayer par1EntityPlayer) {
ItemStack itemstack = par1EntityPlayer.getCurrentEquippedItem();

if(itemstack != null && itemstack.getItem() == Item.appleGold && itemstack.getItemDamage() == 0 && this.isVillager() && this.isPotionActive(Potion.weakness)) {
if(!par1EntityPlayer.capabilities.isCreativeMode) {
--itemstack.stackSize;
}

if(itemstack.stackSize <= 0) {
par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
}

if(!this.worldObj.isRemote) {
this.startConversion(this.rand.nextInt(2401) + 3600);
}

return true;
}else{
return false;
}
}

protected void startConversion(int par1) {
//this.conversionTime = par1;
this.getDataWatcher().updateObject(14, Byte.valueOf((byte)1));
this.removePotionEffect(Potion.weakness.id);
this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, par1, Math.min(this.worldObj.difficultySetting - 1, 0)));
this.worldObj.setEntityState(this, (byte)16);
}

@SideOnly(Side.CLIENT)
public void handleHealthUpdate(byte par1) {
if(par1 == 16) {
this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.zombie.remedy", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
}else{
super.handleHealthUpdate(par1);
}
}

protected boolean canDespawn() {
return !this.isConverting();
}

public boolean isConverting() {
return this.getDataWatcher().getWatchableObjectByte(14) == 1;
}

protected void convertToVillager() {
EntityVillager entityvillager = new EntityVillager(this.worldObj);
entityvillager.copyLocationAndAnglesFrom(this);
entityvillager.onSpawnWithEgg((EntityLivingData)null);
entityvillager.func_82187_q();

if(this.isChild()) {
entityvillager.setGrowingAge(-24000);
}

this.worldObj.removeEntity(this);
this.worldObj.spawnEntityInWorld(entityvillager);
entityvillager.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
}

protected int getConversionTimeBoost() {
int i = 1;

if(this.rand.nextFloat() < 0.01F) {
int j = 0;

for(int k = (int)this.posX - 4;k < (int)this.posX + 4 && j < 14;++k) {
for(int l = (int)this.posY - 4;l < (int)this.posY + 4 && j < 14;++l) {
for(int i1 = (int)this.posZ - 4;i1 < (int)this.posZ + 4 && j < 14;++i1) {
int j1 = this.worldObj.getBlock(k, l, i1);

if(j1 == Block.fenceIron.blockID || j1 == Block.bed.blockID) {
if(this.rand.nextFloat() < 0.3F) {
++i;
}

++j;
}
}
}
}
}

return i;
}
}