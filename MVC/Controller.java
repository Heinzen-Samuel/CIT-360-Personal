package cit360mvcSimple;

import java.util.Vector;

public class Controller {

    public void startApplication() {
        RunwayModel = new Model();
        RunwayModel.initialize();
        View view = new View();

        for (int i = 10; i > 0; i--) {
            String movement = view.newView(currentRunway(), i);

            switch (movement) {
                case "left":
                    moveLeft();
                    break;
                case "right":
                    moveRight();
                    break;
                default:
                    break;
            }
        }
    }

    public String currentRunway() {
        Vector curRun;
        Vector modRun;

        modRun = (Vector)RunwayModel.current().clone();
        curRun = (Vector)modRun.clone();

        String stringRunway = curRun.toString();

        return stringRunway;
    }

    public void moveLeft() {
        Vector curRun = RunwayModel.current();
        int spot;
        spot = curRun.indexOf("X");

        if (spot > 0) { spot--; }

        curRun.clear();
        for (int i = 0; i < 10; i++) {
            curRun.add(i," ");
        }

        curRun.add(spot,"X");

        RunwayModel.update(curRun);
    }

    public void moveRight() {
        Vector curRun = RunwayModel.current();
        int spot;
        spot = curRun.indexOf("X");

        if (spot < 9) { spot++; }

        curRun.clear();
        for (int i = 0; i < 10; i++) {
            curRun.add(i," ");
        }

        curRun.add(spot,"X");

        RunwayModel.update(curRun);
    }

    private Model RunwayModel;
}


