enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL } 

data class Usuario(val nome: String) 

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val grau: Nivel = Nivel.BASICO) {

   	val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        
        inscritos.addAll(usuario)
    }
    
    fun informacao(){
        println("Formação: $nome")
        println("Nível: $grau")
        println("Número de inscritos: ${inscritos.size}")
        println("Conteúdos Educacionais:")
        
        for (i in conteudos.indices) {
            val conteudo = conteudos[i]
            println("  ${conteudo.nome}, Duração: ${conteudo.duracao}")
        }
        
    }
}

fun main() {
   
    val conteudos1: List<ConteudoEducacional> = listOf(
    	ConteudoEducacional("Conceitos", 75),
        ConteudoEducacional("Variáveis", 65),
        ConteudoEducacional("Estrutura de dados", 80),
        ConteudoEducacional("Funções e métodos")
    )
    
    val usuario1 = Usuario("Joao")
    val usuario2 = Usuario("Daniel")
    val usuario3 = Usuario("Pedro")
    val usuario4 = Usuario("Jose")
    
   
    val programacaoBasica = Formacao("Programação Basica", conteudos1) 
    programacaoBasica.matricular(usuario1, usuario2, usuario3, usuario4)
    programacaoBasica.informacao()
}