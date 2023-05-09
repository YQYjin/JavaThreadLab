package Game;

public class Player extends Mover{
    private int HP; //生命值
    Player(int HP){
        this.HP=HP;
    }
    public void injury(Bullet bullet){
        //只受到来自敌人的子弹伤害
        if(bullet.source.equals("enemy")){
            if(HP- bullet.damage>0){
                HP=HP-bullet.damage;
            }else{
                dead();
            }
        }
    }
    public void attack(){

    }
    private void dead(){

    }
}
