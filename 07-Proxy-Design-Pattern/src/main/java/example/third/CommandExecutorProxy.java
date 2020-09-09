package example.third;

public class CommandExecutorProxy implements CommandExecutor {
    private CommandExecutor executor;
    private User user;

    public CommandExecutorProxy(User user) {
        if(isAdmin()){
            executor = new CommandExecutorImpl();
        }
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if(isAdmin()){
            executor.runCommand(cmd);
        }else{
            if(cmd.trim().startsWith("rm")){
                throw new Exception("rm command is not allowed for non-admin users.");
            }else{
                executor.runCommand(cmd);
            }
        }
    }

    private boolean isAdmin(){
        if("Raj".equals(user.getUserName()) && "Bhatta".equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
