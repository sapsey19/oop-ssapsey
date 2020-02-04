from wheel import Wheel

print("burst pressure:" , Wheel.BURST_PRESSURE)

wheel = Wheel(diameter=13.0, pressure = 24.0)
print("pressure:", wheel.pressure)
wheel.pressure = 10000
print(f"pressure: {wheel.pressure}")