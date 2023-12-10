
package br.ufes.gerenciamento.dao;

import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.model.Usuario;
import java.util.List;


public interface INotificacaoDAO {
    void criar(Notificacao notificacao);
    void marcarComoLida(Notificacao notificacao);
    void deletar(Long idNotificacao);
    List<Notificacao> getNotificacoes(Usuario usuario, boolean somenteLidas);
}
