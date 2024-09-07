import unittest

from calculadora import Calculadora

class TestCalculadora(unittest.TestCase):
    def setUp(self):
        self.calc = Calculadora()

    def test_sumar(self):
        self.assertEqual(self.calc.sumar(3, 4), 7)

    def test_dividir(self):
        self.assertEqual(self.calc.dividir(10, 2), 5)
        with self.assertRaises(ValueError):
            self.calc.dividir(10, 0)

    def test_raiz_cuadrada(self):
        self.assertEqual(self.calc.raiz_cuadrada(9), 3)

    def test_potencia(self):
        self.assertEqual(self.calc.potencia(2, 3), 8)

if __name__ == '__main__':
    unittest.main()
