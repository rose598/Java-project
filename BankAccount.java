import java.util.Scanner;

public interface BankAccount {
    public float deposit();//存钱
    public float withdrawl();//取钱
    public float getBalance();//查询余额
}
//处理银行事务
abstract class Deal implements BankAccount{


    float inmoney;//存钱money
    float outmoney;//取钱money
    float exmoney;  //原有资金
    public float deposit(float inmoney,float exmoney){
        this.exmoney=exmoney+inmoney;
        return this.exmoney;
    }

    public float withdrawl(float exmoney,float outmoney) {
        this.exmoney=exmoney-outmoney;
        return this.exmoney;
    }

    public float getBalance(float exmoney) {

        return this.exmoney;
    }
}
    abstract class AbstractBankAccount extends Deal{
      String name;
      String password;
      String id;
       public AbstractBankAccount(String name,String password,String id){
        this.name=name;
        this.password=password;
        this.id=id;
    }
    void show(){
        System.out.println("用户名："+name);
        System.out.println("密码："+password);
        System.out.println("卡号："+id);
}
}
class BankAccountImpl extends AbstractBankAccount{
    public BankAccountImpl(String name,String password,String id){
        super(name,password,id);
    }
    public float deposit(){
        System.out.println("请输入要存的钱数：");
        Scanner sc=new Scanner(System.in);
        inmoney=sc.nextFloat();
        exmoney=super.deposit(inmoney,exmoney);
        System.out.println("存钱成功！");
        return exmoney;

    }
    public float withdrawl() {
        System.out.println("请输入要取的钱数：");
        Scanner sc = new Scanner(System.in);
        outmoney = sc.nextFloat();
        exmoney = super.withdrawl(exmoney, outmoney);
        System.out.println("取钱成功！");

        return exmoney;
    }
    public float getBalance() {
        System.out.println("查询余额成功！");
        return exmoney;
    }



}


