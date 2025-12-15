import characters.*;
import transport.*;

public class Main {
    public static void main(String[] args) {
        try {
            java.util.function.Consumer<core.Statusable> callback =
                    (obj) -> {
                        System.out.println(obj.toString());

                        try {
                            Thread.sleep(core.Actionable.delay_timeout);
                        } catch (InterruptedException e) {
                            System.err.println("Script interrupted: " + e.toString());
                        }
                    };

            var Dunno = new Dunno();
            Dunno.onStatusChange(callback);
            var Smarty = new Smarty();
            Smarty.onStatusChange(callback);

            Dunno.setWish(Wish.TRAVEL);

            var balloon = Smarty.inventTransport(TransportType.BALLOON);
            balloon.onStatusChange(callback);

            Dunno.see(balloon);
            Dunno.setWish(Wish.FLY);
            Dunno.boardTransport(balloon);

            Smarty.setFeeling(Feeling.FEAR);
            Smarty.boardTransport(balloon);

            try {
                balloon.start();
                balloon.action();
                Smarty.setFeeling(Feeling.HAPPY);
                Dunno.setFeeling(Feeling.FEAR);
                balloon.action();
                balloon.stop();
            } catch (BreakException e) {
                e.toString();
            }

            Dunno.leaveTransport(balloon);
            Smarty.leaveTransport(balloon);
            
            Smarty.setWish(Wish.INVENT);
            Smarty.setFeeling(Feeling.HAPPY);



        } catch (core.ScriptException e) {
            System.err.println(e.toString());
        } catch (InterruptedException e) {
            System.err.println("Script interrupted: " + e.toString());
        }
    }
}
