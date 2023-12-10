package br.ufes.gerenciamento.logger;

import br.ufes.gerenciamento.model.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogInfo extends Log {
    public LogInfo(Usuario usuarioAlvo, Usuario usuarioAutenticado, int operacao) {
        super(usuarioAlvo, usuarioAutenticado, operacao);
        createMensagem();
    }
    @Override
    protected void createMensagem() {
        setMensagem(
                getOperacao() + ": " + getUsuarioAlvo().getNome() + ",(" +
                        LocalDate.now().format(
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        ) + ", " +
                        LocalTime.now().format(
                                DateTimeFormatter.ofPattern("HH:mm")
                        ) + ", e " +
                        getUsuarioAutenticado().getUsuario() + ")"
        );
    }
}
