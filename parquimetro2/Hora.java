
/**
 * Escreva uma descrição da classe Hora aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Hora
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int horas, minutos;
    private String período;

    /**
     * Construtor para objetos da classe Hora
     */
    public Hora(int hora, int minuto)
    {
        horas = hora;
        minutos = minuto;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public void adicionarMinutos (int adicionarMinutos)
    {
        minutos = minutos + adicionarMinutos;
        if(minutos >= 60) 
        {
            horas = horas + minutos/60;
            if(horas / 24 >= 1) 
            {
                horas = horas - 24;
            }
            minutos = minutos % 60;
        }
    }
    public String tempo (){
        período = String.format("%d : %d", horas, minutos);
        return período; 
    }
}
