## 1.개요
______________________
프로젝트 이름: 계산기
프로젝트 지속시간 2024/10/24-2024/10/31
개발 언어: java gui


## 2. 설명
______________________
제목은 "계산기"로 설정했고 크기는 300x550 픽셀로 지정했습니다. 컴포넌트를 배치하기 위해 BorderLayout을 사용했습니다.
사용자가 입력할 수 있도록 JTextField를 만들었고 글꼴 크기 정렬 등을 설정하였습니다. 
버튼들은 JPanel으로 생성하고 GridLayout을 사용하여 배치했습니다. 

# 2-1 각 버튼의 기능
______________________
"C": 전체 입력을 지웁니다.
"AC": 마지막 입력을 삭제합니다.
"+/-": 입력의 부호를 변경합니다.
"/", "*", "-", "+": 각각의 사칙연산을 수행합니다.
"0"~"9": 숫자를 입력합니다.
".": 소수점을 입력합니다.
"=": 계산 결과를 표시합니다.

버튼 클릭은 ButtonClickListener를 통해 처리됩니다.
이 클래스는 ActionListener를 구현하여 버튼이 클릭될 때 호출되는 actionPerformed 메서드를 정의하고 있습니다.


# 2-2. 각 버튼의 동작
______________________
"C" 버튼: clear() 메서드를 호출하여 입력을 초기화합니다.
"AC" 버튼: backspace() 메서드를 호출하여 마지막 입력을 삭제합니다.
"+/-" 버튼: toggleSign() 메서드를 호출하여 입력의 부호를 변경합니다.
"=" 버튼: calculate() 메서드를 호출하여 계산을 수행합니다.
사칙연산 버튼: 현재 입력을 firstOperand에 저장하고 선택된 연산자를 operator에 저장합니다.
숫자 버튼 클릭: 입력 문자열에 숫자를 추가합니다.


# 2-3. 각 메서드의 기능
______________________
toggleSign(): 현재 입력이 비어있으면 "-"를 추가하고 입력이 있을 경우 그 값을 반전시킵니다.
calculate(): 선택된 연산자에 따라 결과를 계산하고 그 결과를 텍스트 필드에 표시합니다.
clear(): 텍스트 필드를 초기화합니다.
backspace(): 입력된 마지막 문자를 삭제합니다.
