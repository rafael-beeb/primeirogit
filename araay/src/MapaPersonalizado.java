public class MapaPersonalizado {
    // Arrays para armazenar chaves e valores
    private String[] chaves;
    private int[] numOuro; // Armazena o número de medalhas de ouro
    private String[] ouro; // Armazena descrições ou outros detalhes relacionados às medalhas de ouro
    private int[] numPrata; // Armazena o número de medalhas de prata
    private String[] prata; // Armazena descrições ou outros detalhes relacionados às medalhas de prata
    private int[] numBronze; // Armazena o número de medalhas de bronze
    private String[] bronze; // Armazena descrições ou outros detalhes relacionados às medalhas de bronze

    private int tamanho;

    // Construtor para inicializar o mapa com um tamanho específico
    public MapaPersonalizado(int capacidade) {
        chaves = new String[capacidade];
        numOuro = new int[capacidade];
        ouro = new String[capacidade];
        numPrata = new int[capacidade];
        prata = new String[capacidade];
        numBronze = new int[capacidade];
        bronze = new String[capacidade];

        tamanho = 0;
    }

    // Método para adicionar uma associação chave-valor
    public void adicionar(String chave, int numeroDeOuro, String descricaoOuro,
            int numeroDePrata, String descricaoPrata,
            int numeroDeBronze, String descricaoBronze) {
        // Verifica se a chave já existe e atualiza o valor se necessário
        for (int i = 0; i < tamanho; i++) {
            if (chaves[i] == chave) {
                numOuro[i] = numeroDeOuro;
                ouro[i] = descricaoOuro;
                numPrata[i] = numeroDePrata;
                prata[i] = descricaoPrata;
                numBronze[i] = numeroDeBronze;
                bronze[i] = descricaoBronze;
                return;
            }
        }
        // Se a chave não existe, adiciona uma nova associação
        if (tamanho < chaves.length) {
            chaves[tamanho] = chave;
            numOuro[tamanho] = numeroDeOuro;
            ouro[tamanho] = descricaoOuro;
            numPrata[tamanho] = numeroDePrata;
            prata[tamanho] = descricaoPrata;
            numBronze[tamanho] = numeroDeBronze;
            bronze[tamanho] = descricaoBronze;
            tamanho++;
        } else {
            System.out.println("Mapa cheio!");
        }
    }

    // Método para obter o valor associado a uma chave
    public String obter(String chave) {
        for (int i = 0; i < tamanho; i++) {
            if (chaves[i] == chave) {
                return "Ouro: " + numOuro[i] + " (" + ouro[i] + "), " +
                        "Prata: " + numPrata[i] + " (" + prata[i] + "), " +
                        "Bronze: " + numBronze[i] + " (" + bronze[i] + ")";
            }
        }
        return null;
    }

    public void mostrarMapa() {
        System.out.println("Conteúdo do mapa:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Chave: " + chaves[i]);
            System.out.println("Ouro: " + numOuro[i] + " (" + ouro[i] + ")");
            System.out.println("Prata: " + numPrata[i] + " (" + prata[i] + ")");
            System.out.println("Bronze: " + numBronze[i] + " (" + bronze[i] + ")");
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        // Criar uma instância do mapa personalizado com capacidade para 5 elementos
        MapaPersonalizado mapa = new MapaPersonalizado(5);

        // Adicionar associações chave-valor
        mapa.adicionar("Brasil", 3, "Medalhas de Ouro em Atletismo", 4, "Medalhas de Prata em Natação", 1,
                "Medalhas de Bronze em Ciclismo");
        mapa.adicionar("Japao", 5, "Medalhas de Ouro em Basquete", 2, "Medalhas de Prata em Voleibol", 3,
                "Medalhas de Bronze em Futebol");
        mapa.adicionar("canada", 2, "Medalhas de Ouro em Judô", 6, "Medalhas de Prata em Boxe", 4,
                "Medalhas de Bronze em Ginástica");
        mapa.adicionar("teste1", 7, "Medalhas de Ouro em Atletismo", 1, "Medalhas de Prata em Natação", 2,
                "Medalhas de Bronze em Ciclismo");
        mapa.adicionar("osama", 1, "Medalhas de Ouro em Esgrima", 5, "Medalhas de Prata em Tênis", 6,
                "Medalhas de Bronze em Futsal");

        // Testar o mapa
        String chave = "Brasil";
        String valor = mapa.obter(chave);

        mapa.mostrarMapa();

        // Exibir o valor associado à chave
        System.out.println("Valores associados à chave " + chave + ": " + valor);
    }
}
