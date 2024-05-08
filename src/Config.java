import org.jgap.Chromosome;
import org.jgap.Configuration;
    import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.IChromosome;


public class Config {
    public void configurarAG(int población, int longitud, int numero_evoluciones, int numero_iteraciones) throws InvalidConfigurationException{
        Configuration conf = new DefaultConfiguration();
        FuncionAptitud fa = new FuncionAptitud(longitud);
        try {
            conf.setFitnessFunction(fa);
            conf.setPopulationSize(población);
            IChromosome c = new Chromosome(conf, ejemploChromosome(conf, población));
            conf.setSampleChromosome(c);
            Genotype poblaciGenotype = Genotype.randomInitialGenotype(conf);
            evolucionar(poblaciGenotype, numero_evoluciones, numero_iteraciones, longitud);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Gene[] ejemploChromosome(Configuration conf, int longitud){
        Gene[] ejemplo = new Gene[longitud];
        for (int i = 0; i< longitud; i++){
            try {
                ejemplo[i] = new IntegerGene(conf, 0, 1);
            } catch (InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
        return ejemplo;
    }

    private void evolucionar(Genotype población, int número_evoluciones, int número_iteraciones, int longitud){
        for (int i=0; i < número_iteraciones; i++){
            población.evolve(número_evoluciones);
            población.getFittestChromosome(); //ón.getFitt(número_iteraciones); //
            ImprimirMejores(población.getChromosomes(), longitud);
            System.out.println("--------------------------------");
            ImprimirMejor(población.getFittestChromosome(), longitud);
            System.out.println("--------------------------------");
        }
    }

    private void ImprimirMejores(IChromosome[] ic, int longitud){
        for (IChromosome iChromosome : ic) {
            ImprimirMejor(iChromosome, longitud);
        }
    }

    private void ImprimirMejor(IChromosome ic, int longitud) {
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
        for (int i = longitud/2+1; i < longitud; i++) {
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

        System.out.println("Valor de X: " + valorx + " Valor de Y: " + valory);
        double numero = (-Math.sqrt(Math.pow(vx, 3)))/Math.pow(vy, 2);
        if(Double.isNaN(numero)){
            numero = 0;
        }
        System.out.println("Valor Funcion: " + numero);
    }
}
