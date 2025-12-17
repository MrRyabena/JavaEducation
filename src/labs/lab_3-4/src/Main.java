import characters.*;
import transport.*;

public class Main {
    public static void main(String[] args) {
        try {
            java.util.function.Consumer<core.Statusable> callback = (obj) -> {
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
            var Screw = new Screw();
            Screw.onStatusChange(callback);
            var Dowel = new Dowel();
            Dowel.onStatusChange(callback);

            Dunno.setWish(Wish.TRAVEL);

            var balloon = Smarty.inventTransport(TransportTypes.BALLOON);
            balloon.onStatusChange(callback);

            Dunno.see(balloon);
            Dunno.setWish(Wish.FLY);
            Dunno.boardTransport(balloon);

            Smarty.setFeeling(Feeling.FEAR);
            Smarty.boardTransport(balloon);

            Smarty.driveTransport(balloon, 8);
            Dunno.setFeeling(Feeling.FEAR);
            Dunno.leaveTransport(balloon);
            Smarty.leaveTransport(balloon);

            Smarty.setWish(Wish.INVENT);
            Automobile car = (Automobile) Smarty.inventTransport(TransportTypes.AUTOMOBILE);
            car.onStatusChange(callback);

            Dunno.see(car);
            Dunno.setWish(Wish.DRIVE);
            Dunno.boardTransport(car);

            Dunno.driveTransport(car, 50);

            Smarty.setFeeling(Feeling.SAD);

            var car2 = Smarty.inventTransport(TransportTypes.AUTOMOBILE);
            car2.onStatusChange(callback);

            Screw.boardTransport(car2);
            Dowel.boardTransport(car2);

            Screw.driveTransport(car2, 8);

            Dunno.see(car2);

            car2.compareTo(car);

        } catch (core.ScriptException e) {
            System.err.println("Script error");
            System.err.println(e.toString());

        } catch (InterruptedException e) {
            System.err.println("Script interrupted: " + e.toString());
        }
    }
}
