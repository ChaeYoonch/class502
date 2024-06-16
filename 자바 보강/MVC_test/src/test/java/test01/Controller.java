package test01;

public class Controller {
    // Transfer data between Model and View
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String getCarName() {
        return this.model.getModelName();
    }

    public void setCarName(String name) {
        this.model.setModelName(name);
    }

    public String getLicensePlate() {
        return this.model.getLicensePlate();
    }

    public void setLicensePlate(String licensePlate) {
        this.model.setLicensePlate(licensePlate);
    }
    // . 다른 프로퍼티에 관한 getter setter 메소드는 생략

    public void viewInfo() {
        view.printCarInfo(model.getModelName(), model.getLicensePlate(), model.getReleaseDate(), model.getSeatNum());
    }
}