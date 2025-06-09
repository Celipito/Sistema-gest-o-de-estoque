package cadastroProduto;

import View.TelaPrincipal;
import javax.swing.JFrame;

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        int id = Integer.parseInt(txtBuscarId.getText());
        ProdutosDAO dao = new ProdutosDAO();
        Produtos produto = dao.buscarPorId(id);

        if (produto != null) {
            jTextField1.setText(produto.getNome());
            jTextField2.setText(String.valueOf(produto.getQuantidade()));
            jTextField3.setText(String.valueOf(produto.getPreco()));
            jTextField5.setText(produto.getCategoria());
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Digite um ID válido!");
    }
}
