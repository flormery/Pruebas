package service;

public class ServicioBImpl implements ServicioB {
    private ServicioA servicioA;

    @Override
    public int multiplicar(int i, int i1) {
        return i*i1;
    }

    @Override
    public void setServicioA(ServicioA servicioA) {
        this.servicioA = servicioA;
    }

    @Override
    public int multiplicarSumar(int i, int i1, int i2) {
        return servicioA.sumar(i,i1)*i2;
    }

    @Override
    public ServicioA getServicioA() {
        return servicioA;
    }
}
