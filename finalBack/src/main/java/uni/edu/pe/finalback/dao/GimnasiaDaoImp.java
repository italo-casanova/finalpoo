package uni.edu.pe.finalback.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterBatchUpdateUtils;
import org.springframework.stereotype.Repository;
import uni.edu.pe.finalback.dto.Atleta;
import uni.edu.pe.finalback.dto.AtletaDetalle;
import uni.edu.pe.finalback.dto.Puntacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GimnasiaDaoImp implements GimnasiaDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Connection conexion;

    private void obtenerConexion(){
        try {
            conexion = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public int registrarPuntuacion(Puntacion puntacion) {
        int filasAfectadas = 0;
        try {
            obtenerConexion();
            String sql = "insert into puntuacion values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, puntacion.getIdPuntuacion());
            st.setInt(2, puntacion.getPuntajeJuez1());
            st.setInt(3, puntacion.getPuntajeJuez2());
            st.setInt(4, puntacion.getPuntajeJuez3());
            st.setInt(5, puntacion.getPuntajeJuez4());
            st.setInt(6, puntacion.getPuntajeJuez5());
            st.setInt(7, puntacion.getIdAtleta());
            filasAfectadas = st.executeUpdate();
            st.close();
            cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    @Override
    public int actualizarFlagsAtleta(Atleta atleta) {
        int filasAfectadas = 0;
        try {
            obtenerConexion();
            String sql = "UPDATE atleta a SET a.flg_condicion_medica = ?, a.flg_sustancia_prohibida = ? WHERE (a.id_atleta  = ?);";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, atleta.getFlgCondicionMedica());
            st.setInt(2, atleta.getFlgSustanciaProhibida());
            st.setInt(3, atleta.getIdAtleta());
            filasAfectadas =  st.executeUpdate();
            st.close();
            cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filasAfectadas;
    }

    @Override
    public List<AtletaDetalle> obtenerPuntajePromedio() {
        ArrayList<AtletaDetalle> atletas = new ArrayList<>();
        try {
            obtenerConexion();
            String sql = """
                    select a.nombres, a.talla, a.peso,\s
                                     a.flg_condicion_medica, a.flg_sustancia_prohibida ,\s
                                     p.codigo, p.nombre,\s
                                     (p2.puntaje_juez_5 + p2.puntaje_juez_4 + p2.puntaje_juez_3 + p2.puntaje_juez_2 + p2.puntaje_juez_1) puntaje_promedio\s
                                 from atleta a\s
                                          inner join pais p on a.id_pais = p.id_pais\s
                                          inner join puntuacion p2 on a.id_atleta = p2.id_atleta\s
                                 where a.flg_condicion_medica = 0 and a.flg_sustancia_prohibida = 0\s
                                 order by puntaje_promedio;
                    """;

            PreparedStatement st = conexion.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                AtletaDetalle atletaDetalle = new AtletaDetalle(
                        rs.getString("nombres"),
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getInt("talla"),
                        rs.getInt("flg_condicion_medica"),
                        rs.getInt("flg_sustancia_prohibida"),
                        rs.getInt("puntaje_promedio"),
                        rs.getDouble("peso"));
                atletas.add(atletaDetalle);
            }
            rs.close();
            st.close();
            cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atletas;
    }

    @Override
    public List<Puntacion> obtenerPuntuaciones() {
        ArrayList<Puntacion> p = new ArrayList<>();
        try {
            obtenerConexion();
            String sql = """
                    select p.id_atleta, p.id_puntacion, p.puntaje_juez_1, p.puntaje_juez_2, p.puntaje_juez_3, p.puntaje_juez_4, p.puntaje_juez_5 from puntuacion p;
                    """;

            PreparedStatement st = conexion.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Puntacion atletaDetalle = new Puntacion(
                        rs.getInt("id_puntiacion"),
                        rs.getInt("id_atleta"),
                        rs.getInt("puntaje_juez_1"),
                        rs.getInt("puntaje_juez_2"),
                        rs.getInt("puntaje_juez_3"),
                        rs.getInt("puntaje_juez_4"),
                        rs.getInt("puntaje_juez_5"));
                p.add(atletaDetalle);
            }
            rs.close();
            st.close();
            cerrarConexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
