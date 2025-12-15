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
            var Dowel = new Dowel();
            Dowel.onStatusChange(callback);
            var Screw = new Screw();
            Screw.onStatusChange(callback);

            Dunno.setWish(Wish.TRAVEL);

            var balloon = Smarty.inventTransport(TransportTypes.BALLOON);
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
                System.err.println(e.toString());
            }

            Dunno.leaveTransport(balloon);
            Smarty.leaveTransport(balloon);

            Smarty.setWish(Wish.INVENT);
            Automobile car = (Automobile) Smarty.inventTransport(TransportTypes.AUTOMOBILE);
            car.onStatusChange(callback);

            Dunno.see(car);
            Dunno.setWish(Wish.DRIVE);
            Dunno.boardTransport(car);

            try {

                car.start();
                car.action();
                Dunno.setFeeling(Feeling.EXCITED);
                while (true) {
                    car.action();
                }
            } catch (transport.BreakException e) {
                car = null;
            }
            Dunno.setFeeling(Feeling.SAD);
            Smarty.setFeeling(Feeling.SAD);

            var car2 = Smarty.inventTransport(TransportTypes.AUTOMOBILE);
            car2.onStatusChange(callback);

            Dowel.boardTransport(car2);
            Screw.boardTransport(car2);

            try {
                car2.start();
                car2.action();
                Dunno.setFeeling(Feeling.EXCITED);
                while (true) {
                    car2.action();
                }
            } catch (transport.BreakException e) {
                car2 = null;
            }

        } catch (core.ScriptException e) {
            System.err.println(e.toString());
        } catch (InterruptedException e) {
            System.err.println("Script interrupted: " + e.toString());
        }
    }
}
