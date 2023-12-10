package br.ufes.gerenciamento.session;

import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.service.UsuarioService;

public class Session {
    private static Session instancia;
    private Long idUsuario;
    private UsuarioService usuarioService;
    private static boolean autenticado;

    private Session() {
        usuarioService = UsuarioService.getInstancia();
        this.idUsuario = null;
        this.autenticado = false;
    }

    public static Session getInstancia() {
        if(instancia == null) {
            return new Session();
        }
        return instancia;
    }

    public Usuario getUsuario() {
        if(idUsuario == null) return null;
        return usuarioService.lerPorId(idUsuario);
    }

    public void setUsuario(Usuario usuario) {
        this.idUsuario = usuario.getId();
        setAutenticado(true);
    }

    public static boolean isAutenticado() {
        return autenticado;
    }

    public static void setAutenticado(boolean autenticado) {
        Session.autenticado = autenticado;
    }

}
