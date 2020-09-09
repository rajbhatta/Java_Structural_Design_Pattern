package example.third;

public class ProxyDesignCheck {
    public static void main(String [] args){

        CommandExecutor executor = new CommandExecutorProxy(new User("raj","bhatta"));
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }
    }
}
