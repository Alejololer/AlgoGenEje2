import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FuncionAptitud extends FitnessFunction{

    private int longitud;

    
    public FuncionAptitud(int longitud) {
        this.longitud = longitud;
    }


    @Override
    protected double evaluate(IChromosome ic) {
        String x ="";
        String xd = "";
        for (int i = 1; i < longitud/2; i++){
            if(i >= Math.round(longitud/4))
                xd = xd + (Integer) ic.getGene(i).getAllele();
            else
                x = x + (Integer) ic.getGene(i).getAllele();
        }
        String y = "";
        String yd = "";
        for (int i = longitud/2+1; i < longitud; i++){
            if(i >= Math.round(longitud-longitud/4))
                yd = yd + (Integer) ic.getGene(i).getAllele();
            else
                y = y + (Integer) ic.getGene(i).getAllele();
        }
        int v0 = (int) ic.getGene(0).getAllele(); //Para verificar el primero (signo) lel, alguien llame a dios y dígale que elimine los binarios
        int vx = Integer.parseInt(x, 2);
        double dx = Integer.parseInt(xd, 2) / Math.pow(2, xd.length());
        double valorx = vx + dx;
        int v5 = (int) ic.getGene(5).getAllele(); //Para verificar el primero (signo) lel, alguien llame a dios y dígale que elimine los binarios
        int vy = Integer.parseInt(y,2);
        double dy = Integer.parseInt(xd, 2) / Math.pow(2, yd.length());
        double valory = vy + dy;

        if(v0 == 0){
            valorx= -valorx;
        }
        if(v5 == 0){
            valory = -valory;
        }

        ///int valMaxGen = (int) Math.pow(2, (longitud/2)-1)-1; //Para el mínimo ya no me acordaba esta formula para las cadenas de bits lel
        //double valMax = (-Math.sqrt(Math.pow(valMaxGen, 3)))/Math.pow(valMaxGen, 2);
        //double score = valMax - (-Math.sqrt(Math.pow(vx, 3)))/Math.pow(vy, 2);
        double score = (-Math.sqrt(Math.pow(valorx, 3)))/Math.pow(valory, 2); //Para el máximo
        if (score < 0)
            score = 0;
        return score;
    }
    
}
