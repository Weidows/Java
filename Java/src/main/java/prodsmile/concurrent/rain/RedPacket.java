package prodsmile.concurrent.rain;

public class RedPacket {

    private int id; // 请实现自增逻辑
    private int money; // 单位分
    private byte state; // 0-未发送  1-已发送

    // 增加难度无意义字段，让红包不要太小
    // 水平不够可以删除字段简化题目
    // transient 的意思就是不用持久化，但是内存中得存在
    transient byte[] padding = new byte[1024];

    private RedPacket(int money){
        this.money = money;
    }

    public static RedPacket create(int money) throws InterruptedException {
        Thread.sleep((long) (1000 + (Math.random() * 1000)));
        // 创建红包的逻辑
        return new RedPacket(money);
    }

    static class FailToSendException extends Exception {
    }

    public static void sendTo(User user) throws InterruptedException, FailToSendException {
        // 模拟发送，什么都不做
        Thread.sleep((long) (1000 + (Math.random() * 1000)));
        if(Math.random() > 0.99) {
            throw new FailToSendException();
        }
    }

}
