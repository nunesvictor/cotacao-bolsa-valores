package services.adapters;

import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.classic.ClassicQuandlSession;
import services.ServicoCotacao;

public class QuandlAdapter implements ServicoCotacao {
    private final ClassicQuandlSession session = ClassicQuandlSession.create();

    @Override
    public double getCotacao(String codigoEmpresa) {
        var request = DataSetRequest.Builder
                .of(codigoEmpresa)
                .withMaxRows(1)
                .build();

        var tabularResult = session.getDataSet(request);

        if (tabularResult.size() == 0) {
            System.err.printf("Não foi possível obter a cotação para a empresa %s%n", codigoEmpresa);
            return 0.;
        }

        return tabularResult.get(0).getDouble("Close");
    }
}
