package sptech.projetojpa1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import sptech.projetojpa1.dominio.NivelAcesso
import sptech.projetojpa1.dominio.Usuario

interface UsuarioRepository : JpaRepository<Usuario, Int> {

    // Encontra usuários pelo nome
    fun findByNome(nome: String): List<Usuario>

    // Encontra usuários pelo status
    fun findByStatus(status: Boolean): List<Usuario>

    // Encontra usuários pelo status e nível de acesso
    fun findByStatusTrueAndNivelAcesso(nivelAcesso: NivelAcesso): List<Usuario>

    // Encontra usuários com status verdadeiro
    fun findByStatusTrue(): List<Usuario>

    // Encontra usuário pelo CPF
    fun findByCpf(cpf: String): Usuario?

    // Encontra usuários cujos nomes contenham o texto fornecido (ignorando maiúsculas e minúsculas)
    fun findByNomeContainsIgnoreCase(nome: String): List<Usuario>

    // Encontra usuário pelo e-mail (ignorando maiúsculas e minúsculas)
    fun findByEmailIgnoreCase(email: String): Usuario?

    // Encontra a foto do usuário pelo código
    @Query("select u.foto from Usuario u where u.codigo = ?1")
    fun findFotoByCodigo(codigo: Int): ByteArray?

    fun findByNivelAcesso(nivelAcesso: NivelAcesso): List<Usuario>
}
