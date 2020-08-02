trait Chair {
    def hasLegs: Boolean
    def sitOn
}

trait Sofa {
    def isComfy: Boolean
    def sitOn
}

trait Table {
    def shape: String
    def name: String
}

class ArtDecoChair extends Chair {
    def hasLegs: Boolean = true
    def sitOn = {println("I'm an art deco chair.")}
}

class VictorianChair extends Chair {
    def hasLegs: Boolean = true
    def sitOn = {println("I'm a victorian chair.")}
}

class ModernChair extends Chair {
    def hasLegs: Boolean = false
    def sitOn = {println("I'm a modern chair.")}
}


class ArtDecoSofa extends Sofa {
    def isComfy: Boolean = false
    def sitOn = {println("I'm an art deco sofa.")}
}

class VictorianSofa extends Sofa {
    def isComfy: Boolean = true
    def sitOn = {println("I'm a victorian sofa.")}
}

class ModernSofa extends Sofa {
    def isComfy: Boolean = true
    def sitOn = {println("I'm a modern sofa.")}
}


class ArtDecoTable extends Table {
    def shape: String = "round"
    def name: String = "I'm an art deco table."
}

class VictorianTable extends Table {
    def shape: String = "square"
    def name: String = "I'm a victorian table."
}

class ModernTable extends Table {
    def shape: String = "rectangular"
    def name: String = "I'm a modern table."
}

trait FurnitureFactory {
    def getChair: Chair
    def getSofa: Sofa
    def getTable: Table
}

class ArtDecoFurnitureFactory extends FurnitureFactory {
    def getChair: Chair = new ArtDecoChair
    def getSofa: Sofa = new ArtDecoSofa
    def getTable: Table = new ArtDecoTable
}

class VictorianFurnitureFactory extends FurnitureFactory {
    def getChair: Chair = new VictorianChair
    def getSofa: Sofa = new VictorianSofa
    def getTable: Table = new VictorianTable
}

class ModernFurnitureFactory extends FurnitureFactory {
    def getChair: Chair = new ModernChair
    def getSofa: Sofa = new ModernSofa
    def getTable: Table = new ModernTable
}

class Application(furnitureFactory: FurnitureFactory) {
    val chair = furnitureFactory.getChair
    val sofa = furnitureFactory.getSofa
    val table = furnitureFactory.getTable

    println("Chair has legs: " + chair.hasLegs)
    chair.sitOn
    println("Sofa is comfy : " + sofa.isComfy)
    sofa.sitOn
    println("Table shape: " + table.shape)
    println(table.name)
}


object Runner{
    def main(argv: Array[String]){
        new Application(createFurnitureFactory(argv(0)))
    }

    def createFurnitureFactory(furnitureType: String): FurnitureFactory = {
        furnitureType match {
            case "ArtDeco" => new ArtDecoFurnitureFactory
            case "Victorian" => new VictorianFurnitureFactory
            case "Modern" => new ModernFurnitureFactory
        }
    }
}












