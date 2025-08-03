import java.util.Map;

public record ObtenerDatos(
        String base_code,
        Map<String, Double> conversion_rates
    ) {}
