public class App {
    public static void main(String [] args){
        ChatController cc = new ChatController("tema");

        Vid dialog = new Vid();
        dialog.pack();
        dialog.setSize(800, 600);
        dialog.setVisible(true);
        System.exit(0);


        cc.dobavitSoobch("Привет, чат");
    }
}
