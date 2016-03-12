package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PessoaTableModel 
	extends AbstractTableModel {

	private ArrayList<Pessoa> pessoas 
		= new ArrayList<>();
	private String[] colunas = {"Nome", "Idade"};
			
	public void adicionar(Pessoa pessoa) {
		if (pessoas.contains(pessoa)) {
			pessoas.remove(pessoa);
		}
		pessoas.add(pessoa);
		fireTableDataChanged();
	}
	
	public void remover(int rowIndex) {
		pessoas.remove(rowIndex);
		fireTableDataChanged();
	}
	
	public Pessoa getPessoa(int rowIndex) {
		return pessoas.get(rowIndex);
	}
	
	@Override
	public int getRowCount() {
		return pessoas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pessoa pessoa = pessoas.get(rowIndex);
		
		if (columnIndex == 0)
			return pessoa.getNome();
		
		if (columnIndex == 1)
			return pessoa.getIdade();
		
		return null;
	}

}
