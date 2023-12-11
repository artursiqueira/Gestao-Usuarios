package br.ufes.gerenciamento.state.configuracao;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.presenter.ConfiguracoesPresenter;
import br.ufes.gerenciamento.command.configuracoes.AlterarLogCommandTemplate;
import javax.swing.*;

public class ProntoParaConfigurarConfiguracoesState extends ConfiguracoesState {
    public ProntoParaConfigurarConfiguracoesState(ConfiguracoesPresenter presenter) {
        super(presenter);
        this.view.getBtnFechar().setEnabled(true);
        this.view.getBtnSalvar().setEnabled(true);
        this.view.getCbFormatoLog().setEnabled(true);
        this.view.getCbFormatoLog().setSelectedItem(Application.getLogFormat());
    }
    @Override
    public void salvar() {
        new AlterarLogCommandTemplate(presenter) {
            @Override
            public void onStart(){
                presenter.setState(new ConfigurandoConfiguracoesState(presenter));
            }

            @Override
            public void onSuccess() {
                JOptionPane.showMessageDialog(
                        view,
                        "Alteração de formato de log realizada com sucesso!",
                        "sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            @Override
            public void onError(Exception ex) {
                throw new RuntimeException(ex);
            }

            @Override
            public void onFinish() {
                presenter.setState(new ProntoParaConfigurarConfiguracoesState(presenter));
            }
        }.executar();

    }

}
