public class Run {
    public static void main(String[] args) {
        App app = new App("PM2.5");
        Menu menu =new Menu(app);
        Main_ main=new Main_(app);
        StudentIDCardLayout orgenizer=new StudentIDCardLayout();
        app.add(orgenizer,"orgenizer");
        app.add(menu,"menu");
        app.add(main,"main");
    }
}
