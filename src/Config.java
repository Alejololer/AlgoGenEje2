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
        FuncionAptitud fa = new FuncionAptitud();
        try {
            conf.setFitnessFunction(fa);
            conf.setPopulationSize(población);
            IChromosome c = new Chromosome(conf, ejemploChromosome(conf, población));
            conf.setSampleChromosome(c);
            Genotype poblaciGenotype = Genotype.randomInitialGenotype(conf);
            evolucionar(poblaciGenotype, numero_evoluciones, numero_iteraciones);
        } catch (InvalidConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Gene[] ejemploChromosome(Configuration conf, int longitud){
        Gene[] ejemplo = new Gene[longitud];
        for (int i = 0; i< longitud; i++){
            try {
                ejemplo[i] = new IntegerGene(conf, 0, 1);
            } catch (InvalidConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ejemplo;
    }

    private void evolucionar(Genotype población, int número_evoluciones, int número_iteraciones){
        for (int i=0; i < número_iteraciones; i++){
            población.evolve(número_evoluciones);
            población.getFittestChromosome(); //ón.getFitt(número_iteraciones); //
            ImprimirMejores(población.getChromosomes());
            System.out.println("--------------------------------");
            ImprimirMejor(población.getFittestChromosome());
            System.out.println("--------------------------------");
        }
    }

    private void ImprimirMejores(IChromosome[] ic){
        for (IChromosome iChromosome : ic) {
            ImprimirMejor(iChromosome);
        }
    }

    private void ImprimirMejor(IChromosome ic){
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
        double score =(vx*vx)+(vy*vy)+(vz*vz);
        if(score<0){
            score=0;
        }
        System.out.println(vx+" "+vy+" "+vz);
    }
}
