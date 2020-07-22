package br.com.sg.snackxpress.enumerator;

public class UnitMeasurement {
    public static enum UM {

        UN("Unidade"),
        L("Litro"),
        ML("Mililitro"),
        KG("Kilo"),
        DZ("Duzia");

        private String desc;

        UM(String desc) {
            this.desc = desc;
        }

    }
}
