import java.sql.DriverManager

class ProductDAO {
    val connection = DriverManager.getConnection("jdbc:h2:./default", "admin", "admin")

    fun createProduct(product: Product): Int {
        val statement = connection.prepareStatement("INSERT INTO PRODUCTS (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)")

        statement.setInt(1, product.id)
        statement.setString(2, product.name)
        statement.setFloat(3, product.price)
        statement.setString(4, product.description)
        statement.setString(5, product.brand)
        statement.setString(6, product.category)
        statement.executeUpdate()
        return product.id
    }
}