package services.adapters;

import io.github.mainstringargs.yahooFinance.YahooFinanceModules;
import io.github.mainstringargs.yahooFinance.YahooFinanceRequest;
import io.github.mainstringargs.yahooFinance.YahooFinanceUrlBuilder;
import services.ServicoCotacao;

public class YahooAdapter implements ServicoCotacao {
    @Override
    public double getCotacao(String codigoEmpresa) {
        var builder =
                new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codigoEmpresa);

        var request = new YahooFinanceRequest();
        var financeData = request.getFinanceData(request.invoke(builder));
        var financialData = financeData.getFinancialData();

        if (financialData == null) {
            System.err.printf("Não foi possível obter a cotação para a empresa %s%n", codigoEmpresa);
            return 0.;
        }

        return financialData.getCurrentPrice().getRaw().doubleValue();
    }
}
