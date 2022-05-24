/**I have placed the JSON-format questions and associated JavaScript functions in the same file for simplicity. 
 The <script src> tag in the Test.html file directs the HTML to pull question data from this file via the JavaScript loadQuiz() function.**/

const quizData = [
    {
        question: "A Java application can run",
        a: "On any computer with Java",
        b: "Only on a Windows PC",
        c: "Only on Monday, Wednesday and Friday",
        d: "On any networked computer",
        correct: "a",
    },
    {
        question: "Java accepts and displays keyboard input",
        a: "With a magic wand",
        b: "With HTML",
        c: "With the doGet Servlet method",
        d: "With the Scanner and Print methods",
        correct: "d",
    },
    {
        question: "A For/While loop:",
        a: "Can run forever if you just let it",
        b: "Will run until the While condition is not true",
        c: "Makes the IDE crash",
        d: "Is an iterative method designed for undetermined data sets",
        correct: "b",
    },
    {
        question: "John Gosling invented Java specifically to avoid",
        a: "Rewriting the same code for the various Operating Systems",
        b: "Getting bored",
        c: "The need to reboot after a software update",
        d: "The processing limitations of some older model computers",
        correct: "a",
    },
    {
        question: "What is the purpose of a variable?",
        a: "It has no purpose",
        b: "To store data for method operations",
        c: "To make sure other applications don't take too much memory",
        d: "To shut down the application",
        correct: "b",
    },
];


const quiz= document.getElementById('quiz')
const answer1 = document.querySelectorAll('.answer')
const question = document.getElementById('question')
const a_text = document.getElementById('a_text')
const b_text = document.getElementById('b_text')
const c_text = document.getElementById('c_text')
const d_text = document.getElementById('d_text')
const submitBtn = document.getElementById('submit')

let currentQuiz = 0
let score = 0

loadQuiz()

function loadQuiz() {

    deselectAnswers()

    const currentQuizData = quizData[currentQuiz]

    question.innerText = currentQuizData.question
    a_text.innerText = currentQuizData.a
    b_text.innerText = currentQuizData.b
    c_text.innerText = currentQuizData.c
    d_text.innerText = currentQuizData.d
}

function deselectAnswers() {
    answer1.forEach(answer2 => answer2.checked = false)
}

function getSelected() {
    let answer
    answer1.forEach(answer2 => {
        if(answer2.checked) {
            answer = answer2.id
        }
    })
    return answer
}

submitBtn.addEventListener('click', () => {
    const answer = getSelected()
    if(answer) {
       if(answer === quizData[currentQuiz].correct) {
           score++
       }

       currentQuiz++

       if(currentQuiz < quizData.length) {
           loadQuiz()
       } else {
           quiz.innerHTML = `

	  <h2>Review</h2>

  	  <h3><b>A Java application can run</h3></b>
      <p>Correct Answer: C - On any computer with Java</p>
 
      <h3><b>Java accepts and displays keyboard input</h3></b>
      <p>Correct Answer: D - With the Scanner and Print methods</p>
     
      <h3><b>A For/While loop</h3></b>
      <p>Correct Answer: B - Will run until the While condition is not true</p>
	 
      <h3><b>John Gosling invented Java specifically to avoid</h3></b>
      <p>Correct Answer: A - Rewriting the same code for the various Operating Systems</p>
        
      <h3><b>What is the purpose of a variable?</h3></b>
      <p>Correct Answer: B - To store data for method operations</p><br>

      <h2>You answered ${score} out of the ${quizData.length} questions correctly</h2>

      <button onclick="location.reload()">Retake Quiz</button>`
}
}
})