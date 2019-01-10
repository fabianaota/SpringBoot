import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        LocalDateTime horarioAtual = LocalDateTime.now();

        LocalDateTime meioDia = LocalDateTime.now().withHour(12);

        saudacao(horarioAtual, meioDia);

        ArrayList<String> listaNomes = new ArrayList<>();
        listaNomes.add("Fábio");
        listaNomes.add("João");
        listaNomes.add("Pedro");
        listaNomes.add("Fábio");

        Optional<String> nomesConcatenados = listaNomes.stream()
                //.map(nome -> nome + "!")
                //.filter(Principal::test)
                .reduce((nome1, nome2) -> nome1 + nome2);
        nomesConcatenados.ifPresent(System.out::println);

        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Sesc");
        projeto.setDataInicio(LocalDateTime.now());

        projeto.setIntegranteList(new ArrayList<>());

        IntegranteProjeto desenvolvedor = new Desenvolvedor();
        projeto.getIntegranteList().add(desenvolvedor);

        IntegranteProjeto desenvolvedor2 = new Desenvolvedor();
        projeto.getIntegranteList().add(desenvolvedor2);

        IntegranteProjeto gerente = new GerenteDeProjeto();
        projeto.getIntegranteList().add(gerente);

        projeto.fazerDM();

        for (Method method : Projeto.class.getDeclaredMethods()) {
            if (method.getName().contains("get")) {
                System.out.println(method);
                try {
                    System.out.println(method.invoke(projeto));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void saudacao(LocalDateTime horarioAtual, LocalDateTime meioDia) {
        if (horarioAtual.isAfter(meioDia)) {
            System.out.println("Bom tarde!");
        }
        else {
            System.out.println("Bom dia!");
        }
    }

    private static boolean test(String nome) {
        return nome.contains("a");
    }
}