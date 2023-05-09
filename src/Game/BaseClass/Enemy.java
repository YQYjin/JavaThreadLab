package Game;

public class Enemy extends Mover{
    private int HP; //生命值
    //受到攻击
    public void injury(Bullet bullet){
        //只受到玩家发出的子弹攻击
        if(bullet.source.equals("player")){
            if(HP- bullet.damage>0){
                HP=HP-bullet.damage;
            }else{
                dead();
            }
        }

    }
    public void attack(){

    }
    //死亡
    private void dead(){

    }
}
