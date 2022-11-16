package services.adapters;

import io.github.mainstringargs.alphavantagescraper.AlphaVantageConnector;
import io.github.mainstringargs.alphavantagescraper.StockQuotes;
import io.github.mainstringargs.alphavantagescraper.output.AlphaVantageException;
import services.ServicoCotacao;

public class AlphaVantageAdapter implements ServicoCotacao {
    private final String s = System.getenv("ALPHAVANTAGE_APIKEY");
    private final String apiKey = s == null ? "50M3AP1K3Y" : s;

    @Override
    public double getCotacao(String codigoEmpresa) {
        int timeout = 3000;
        var apiConnector = new AlphaVantageConnector(apiKey, timeout);
        var stockQuotes = new StockQuotes(apiConnector);

        try {
            var response = stockQuotes.quote(codigoEmpresa);
            var stockQuote = response.getStockQuote();

            return stockQuote.getPrice();
        } catch (AlphaVantageException e) {
            System.err.println("Erro ao solicitar cotação da empresa " + codigoEmpresa + ": " + e.getMessage());
            return 0.;
        }
    }
}
