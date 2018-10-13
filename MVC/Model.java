package cit360mvcSimple;

import java.util.Vector;

public class Model {

    public Vector<String> current () {
        return runway;
    }

    public void update(Vector<String> data) {
        runway = (Vector)data.clone();
    }

    public void initialize() {
        for (int i = 0; i < 10; i++) {
            runway.add(i," ");
        }

        runway.add(4,"X");
    }

    private Vector<String> runway = new Vector<>(10);
}
