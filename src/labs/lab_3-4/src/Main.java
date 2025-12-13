import characters.*;

import transport.*;

public class Main {
    public static void main(String[] args) {
        try {

            var Dunno = new Dunno();
            Dunno.onStatusChange(
                    (obj) -> {
                        System.out.println(obj.toString());
                    });
            var Smarty = new Smarty();
            Smarty.onStatusChange(
                    (obj) -> {
                        System.out.println(obj.toString());
                    });

            Dunno.setWish(Wish.TRAVEL);

            var balloon = Smarty.makeBalloon();
            balloon.onStatusChange(
                    (obj) -> {
                        System.out.println(obj.toString());
                    });
            Smarty.boardTransport(balloon);
            Dunno.boardTransport(balloon);

            balloon.start();

        } catch (core.ScriptException e) {
            System.err.println(e.toString());
            return;
        }
    }
}
