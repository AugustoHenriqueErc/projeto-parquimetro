
/**
 * Representa um parquímetro fracionado simplificado.
 * 
 * O parquímetro funciona assim:
 * 1. o cliente seleciona a quantidade de tempo
 *    de estacionamento, incrementando-o
 *    de 15 em 15 minutos.
 * 2. o cliente insere o dinheiro suficiente para
 *    pagar o ticket de estacionamento.
 * 3. o cliente pede para imprimir o ticket.
 * 
 * O parquímetro mantém o total de dinheiro acumulado
 * ao longo do tempo em que está em operação.
 * 
 * @author Daniel Conrado 
 * @version 2023
 */
public class Parquimetro
{
    // campo que armazena quanto custa cada unidade de tempo solicitada.
    // p. ex. o preço unitário a cada 15 minutos comprados.
    private int preçoUnitario;
    // armazena o tempo total sendo solicitado
    private int tempoSolicitado;
    // quantidade de dinheiro já inserida pelo cliente
    private int balanço;
    // quantidade total de dinheiro acumulado por este parquímetro
    private int total;
    //armazena quantidade de vezes que o tempo foi solicitado
    private int aumentarTempoCont = 0;
    //armazena quantidade a pagar
    private int totalApagar;
    
    /**
     * Constroi um novo objeto Parquimetro com o preço unitário configurado.
     */
    public Parquimetro(int preçoDaFração)
    {
        preçoUnitario = preçoDaFração;
        tempoSolicitado = 15;
        balanço = 0;
        total = 0;
    }

    public void inserirDinheiro(int quantia)
    {
        balanço = balanço + quantia;
    }
    
    public void aumentarTempo()
    {
        tempoSolicitado = tempoSolicitado + 15;
        aumentarTempoCont++;
    }
    
    public void imprimirTicket(int horaAtual, int minutoAtual)
    {
        if(balanço >= preçoUnitario) {
            System.out.println("+--------------------------+");
            System.out.println("| Ticket de Zona Azul      |");
            System.out.println("+--------------------------+");
            System.out.printf ("| Início: %02d:%02d            |\n", horaAtual, minutoAtual);
            System.out.println("|                          |");
            System.out.printf ("| Válido por: %-13s|\n", tempoSolicitado + "min");
            System.out.println("+--------------------------+");
            
            total = total + balanço;
            tempoSolicitado = 15;
            balanço = 0;
        }
    }
    
    public int getPreçoUnitario()
    {
        return preçoUnitario;
    }
    
    public int getTempoSolicitado()
    {
        return tempoSolicitado;
    }
    
    public int getBalanço()
    {
        return balanço;
    }
    public int getTotalApagar()
    {
        totalApagar = aumentarTempoCont * 50;
        return totalApagar;
    }
}
