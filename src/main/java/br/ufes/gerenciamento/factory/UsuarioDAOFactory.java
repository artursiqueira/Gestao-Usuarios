package br.ufes.gerenciamento.factory;

import br.ufes.gerenciamento.dao.IUsuarioDAO;
import br.ufes.gerenciamento.dao.IUsuarioDAOFactory;
import br.ufes.gerenciamento.daoimpl.UsuarioSQLiteDAO;

public class UsuarioDAOFactory implements IUsuarioDAOFactory {

    @Override
    public IUsuarioDAO cria(String tipo) {
        switch (tipo) {
            case "sqlite":
                return new UsuarioSQLiteDAO();
            default:
                throw new RuntimeException("Tipo de DAO não suportado");
        }
    }

}
