public record Monedas(String title,
                      String base_code,
                      int cantidad,
                      String target_code,
                      double conversion_rate,
                      double conversion_result) {

    @Override
    public String title() {
        return "Lista de Conversiones";
    }
}
