import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FuncionAptitud extends FitnessFunction{

    @Override
    protected double evaluate(IChromosome ic) {
        Integer v0 = (Integer) ic.getGene(0).getAllele();
        Integer v1 = (Integer) ic.getGene(1).getAllele();
        Integer v2 = (Integer) ic.getGene(2).getAllele();
        Integer v3 = (Integer) ic.getGene(3).getAllele();
        Integer v4 = (Integer) ic.getGene(4).getAllele();
        Integer v5 = (Integer) ic.getGene(5).getAllele();
        Integer v6 = (Integer) ic.getGene(6).getAllele();
        Integer v7 = (Integer) ic.getGene(7).getAllele();
        Integer v8 = (Integer) ic.getGene(8).getAllele();
        Integer v9 = (Integer) ic.getGene(9).getAllele();
        Integer v10 = (Integer) ic.getGene(10).getAllele();
        Integer v11 = (Integer) ic.getGene(11).getAllele();
        Integer v12 = (Integer) ic.getGene(12).getAllele();
        Integer v13 = (Integer) ic.getGene(13).getAllele();
        Integer v14 = (Integer) ic.getGene(14).getAllele();
        Integer v15 = (Integer) ic.getGene(15).getAllele();
        String x = v1.toString() + v2.toString() + v3.toString() + v4.toString();
        String y = v6.toString() + v7.toString() + v8.toString() + v9.toString();
        String z = v11.toString() + v12.toString() + v13.toString() + v14.toString();
        int vx = Integer.parseInt(x,2);
        int vy = Integer.parseInt(y,2);
        int vz = Integer.parseInt(z,2);
        if(v0==0){
            vx = -vx;
        }
        if(v5==0){
            vy = -vy;
        }
        if(v10==0){
            vz = -vz;
        }
        double score =675-(vx*vx)+(vy*vy)+(vz*vz);
        if(score<0){
            score=0;
        }
        System.out.println(vx+" "+vy+" "+vz);
        return score;
    }
    
}
