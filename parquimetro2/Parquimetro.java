
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
    //armazena quantidade a pagar
    private int totalApagar;
    //armazena se o parquímetro é turístico ou não
    private boolean areaTurística = false;
    //armazena o troco se existir
    private int troco;
    //armazena a rotatividade
    private boolean altaRotatividade = false;
    //armazena o total que foi esvaziado do parquímetro
    private int valorRetirado;
    //se torna false caso o usuário tenha troco a retirar, ou tenha depositado e não tenha impresso o ticket
    private boolean retirarValor = true;
    //armazena o objeto horas
    private Hora horaSaída;
    //armazena a string do método tempo
    private String tempoSaída;
    /**
     * Constroi um novo objeto Parquimetro com o preço unitário configurado.
     */
    public Parquimetro(int preçoDaFração, boolean turismo, boolean rotatividade)
    {
        preçoUnitario = preçoDaFração;
        balanço = 0;
        areaTurística = turismo;
        altaRotatividade = rotatividade;
        if(areaTurística) 
        {
            tempoSolicitado = 60;
            totalApagar = 150;
        }
        else
        {
            tempoSolicitado = 15;
            totalApagar = 50;
        }
    }
    public void inserirDinheiro(int quantia)
    {
        if(balanço + quantia <= 250) 
        {
            balanço = balanço + quantia;    
        }
        else 
        {
            balanço = 250;    
        }
    }
    
    public void aumentarTempo()
    {
        if(altaRotatividade) 
        {
            if(tempoSolicitado >= 30 && tempoSolicitado < 60) 
            {
            tempoSolicitado = tempoSolicitado + 15;
            }
            if (tempoSolicitado < 60) 
            {
            tempoSolicitado = tempoSolicitado + 15;
            }    
        }
        else 
        {
            if(tempoSolicitado >= 30 && tempoSolicitado < 120) 
            {
                tempoSolicitado = tempoSolicitado + 15;
            }
            if (tempoSolicitado < 120) 
            {
                tempoSolicitado = tempoSolicitado + 15;
            }         
        }
    }

    public void imprimirTicket(int horaAtual, int minutoAtual)
    {
        horaSaída = new Hora(horaAtual, minutoAtual);
        horaSaída.adicionarMinutos(tempoSolicitado);
        tempoSaída = horaSaída.tempo();
        
        if(balanço >= totalApagar && totalApagar!= 0) {
            System.out.println("+--------------------------+");
            System.out.println("| Ticket de Zona Azul      |");
            System.out.println("+--------------------------+");
            System.out.printf ("| Início: %02d:%02d            |\n", horaAtual, minutoAtual);
            System.out.println("|                          |");
            System.out.printf ("| Válido por: %-13s|\n", tempoSolicitado + "min");
            System.out.println("|                          |");
            System.out.printf ("| Horário de saída: %s|\n", tempoSaída);
            System.out.println("+--------------------------+");
            total = total + balanço;
            balanço = balanço - totalApagar;
            if(areaTurística) {
                tempoSolicitado = 60;
            }
            else{
                tempoSolicitado = 15;
            }
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
    
    public int devolverTroco() 
    {
         troco = balanço;
         balanço = 0;
         total = total - troco;
         return troco;
    }
    
    public int esvaziar() 
    {
        if(balanço != 0) {
        }
        else {
            valorRetirado = total;
            total = 0;
        }
        return valorRetirado;
    }
    
    public int getBalanço()
    {
        return balanço;
    }
    
    public int getTotalApagar()
    {
        switch(tempoSolicitado) {
            case 15:
                totalApagar = 50;
                break;
            case 30:
                totalApagar = 100;
                break;
            case 60:
                totalApagar = 150;
                break;
            case 90: 
                totalApagar = 200;
                break;
            case 120:
                totalApagar = 250;
                break;
            default:    
                break;
        }
        return totalApagar;
    }
}
