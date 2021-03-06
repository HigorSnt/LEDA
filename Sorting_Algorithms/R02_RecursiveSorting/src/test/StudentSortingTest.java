package test;

import java.util.Arrays;
import java.util.Random;

import main.sorting.AbstractSorting;
import main.sorting.divideAndConquer.threeWayQuicksort.ThreeWayQuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new ThreeWayQuickSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	private Integer[] vetorDecrescente;
	private Integer[] vetorGiganteDecrescente;

	@Before
	public void otherSetUp(){
		popularVetorDescrescente(new Integer[] {25, 24, 23, 22, 21, 20, 19, 18,
				17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
		popularVetorGiganteDescrescente();
	}

	// Métodos para popular os novos arrays criados
	public void popularVetorDescrescente(Integer[] arrayPadrao){
		this.vetorDecrescente = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void popularVetorGiganteDescrescente(){
		int size = getRandom(0, 70000);
		vetorGiganteDecrescente = new Integer[size];

		for(int index = 0; index < size; index++){
			vetorGiganteDecrescente[index] = getRandom(-10000, 90000);
		}
	}

	public int getRandom (int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	// Métodos que realizarão os testes
	@Test
	public void testSort06() {
		genericTest(vetorDecrescente);
	}

	@Test
	public void testSort07() {
		genericTest(vetorGiganteDecrescente);
	}
}