import services.ServicoCotacao;
import services.adapters.AlphaVantageAdapter;
import services.adapters.QuandlAdapter;
import services.adapters.YahooAdapter;

/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 *
 * <p>
 * Observe que os métodos {@link #cotacaoUsandoYahooFinance(String)},
 * {@link #cotacaoUsandoAlphaVantage(String)} e
 * {@link #cotacaoUsandoQuandl(String)} não estão retornando nada, pois
 * isto é apenas um exemplo.
 * Se formos usar esta implementação em uma aplicação com interface gráfica (e não console),
 * o usuário não vai ver os prints inseridos.
 * Por isso neste caso, os método pra serem úteis para qualquer tipo de app (web, mobile, desktop, console, etc),
 * precisam retornar algum dado. Se tivermos uma app web, por exemplo, podemos então pegar estes dados e exibir
 * em uma página HTML.
 * Como você irá remodelar o código para aplicar o projeto, você precisa fazer estas alterações.
 * </p>
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        ServicoCotacao servicoCotacao;
        System.out.println();

        servicoCotacao = new YahooAdapter();
        System.out.printf("YahooAdapter (MGLU3.SA): %.2f\n", servicoCotacao.getCotacao("MGLU3.SA"));

        servicoCotacao = new AlphaVantageAdapter();
        System.out.printf("AlphaVantageAdapter (INTC): %.2f\n", servicoCotacao.getCotacao("INTC"));

        servicoCotacao = new QuandlAdapter();
        System.out.printf("QuandlAdapter (WIKI/AAPL): %.2f\n", servicoCotacao.getCotacao("WIKI/AAPL"));
    }
}
