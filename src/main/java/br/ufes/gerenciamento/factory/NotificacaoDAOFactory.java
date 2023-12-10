package br.ufes.gerenciamento.factory;

import br.ufes.gerenciamento.dao.INotificacaoDAO;
import br.ufes.gerenciamento.dao.INotificacaoDAOFactory;
import br.ufes.gerenciamento.daoimpl.NotificacaoSQLiteDAO;

public class NotificacaoDAOFactory implements INotificacaoDAOFactory {

    @Override
    public INotificacaoDAO cria(String tipo) {
        switch (tipo) {
            case "sqlite":
                return new NotificacaoSQLiteDAO();
            default:
                throw new RuntimeException("Tipo de DAO não suportado");
        }
    }

}
